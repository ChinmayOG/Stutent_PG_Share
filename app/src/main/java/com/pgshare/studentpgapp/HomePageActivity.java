package com.pgshare.studentpgapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    private List<Room> roomList;
    private RecyclerView roomRecyclerView;
    private RoomAdapter roomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Initialize RecyclerView and RoomAdapter
        roomList = getSampleRoomData();
        roomRecyclerView = findViewById(R.id.roomListRecyclerView);
        roomAdapter = new RoomAdapter(roomList);

        // Set up RecyclerView with a LinearLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        roomRecyclerView.setLayoutManager(layoutManager);

        // Set the adapter to the RecyclerView
        roomRecyclerView.setAdapter(roomAdapter);

        // Button for adding a new room
        Button addRoomButton = findViewById(R.id.btnAddRoom);
        addRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create and show the dialog
                AddRoomDialog addRoomDialog = new AddRoomDialog(HomePageActivity.this, new AddRoomDialog.OnRoomAddedListener() {
                    @Override
                    public void onRoomAdded(Room newRoom) {
                        // Handle the new room added
                        roomList.add(newRoom);
                        roomAdapter.notifyDataSetChanged();
                    }
                });
                addRoomDialog.show();
            }
        });
    }

    // Function to get sample room data
    private List<Room> getSampleRoomData() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Room 101", "Palghar", 500, R.drawable.default_room_image));
        rooms.add(new Room("Room 202", "Mumbai", 600, R.drawable.default_room_image));
        rooms.add(new Room("Room 303", "Delhi", 700, R.drawable.default_room_image));
        // Add more rooms as needed
        return rooms;
    }
}
