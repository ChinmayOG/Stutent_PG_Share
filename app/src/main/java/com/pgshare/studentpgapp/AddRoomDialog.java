package com.pgshare.studentpgapp;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRoomDialog extends AlertDialog.Builder {

    public interface OnRoomAddedListener {
        void onRoomAdded(Room newRoom);
    }

    private OnRoomAddedListener onRoomAddedListener;

    public AddRoomDialog(Context context, OnRoomAddedListener listener) {
        super(context);
        this.onRoomAddedListener = listener;

        // Inflate the custom layout for the dialog
        View view = LayoutInflater.from(context).inflate(R.layout.activity_add_room, null);
        setView(view);

        // Set up dialog buttons and logic
        Button addButton = view.findViewById(R.id.btnAddRoom);
        addButton.setOnClickListener(this::handleAddRoomButtonClick);

        setNegativeButton("Cancel", (dialogInterface, i) -> {
            // Cancel the dialog
        });
    }

    private void handleAddRoomButtonClick(View view) {
        // Get user input
        EditText roomNameEditText = view.findViewById(R.id.editTextRoomName);
        EditText locationEditText = view.findViewById(R.id.editTextLocation);
        EditText priceEditText = view.findViewById(R.id.editTextPrice);

        String roomName = roomNameEditText.getText().toString();
        String location = locationEditText.getText().toString();
        double price = Double.parseDouble(priceEditText.getText().toString());

        // Create a new room object and notify the listener
        Room newRoom = new Room(roomName, location, price, R.drawable.default_room_image);
        if (onRoomAddedListener != null) {
            onRoomAddedListener.onRoomAdded(newRoom);
        }
    }
}
