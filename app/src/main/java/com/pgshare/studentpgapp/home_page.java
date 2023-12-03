package com.pgshare.studentpgapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class home_page extends AppCompatActivity {

    private List<Room> roomList;
    private RecyclerView roomRecyclerView;
    private RoomAdapter roomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        roomList = getSampleRoomData();
        roomRecyclerView = findViewById(R.id.roomListRecyclerView);
        roomAdapter = new RoomAdapter(roomList);

        // Set up RecyclerView with a LinearLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        roomRecyclerView.setLayoutManager(layoutManager);
        roomRecyclerView.setAdapter(roomAdapter);

        // You can add more functionality here, such as handling search bar input or item click events.
    }

    @NonNull
    private List<Room> getSampleRoomData() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Room 101", "Palghar", 500, R.mipmap.pg_sample_foreground));
        rooms.add(new Room("Room 202", "Mumbai.", 600, R.mipmap.img_1_foreground));
        rooms.add(new Room("Room 303", "Delhi", 700, R.mipmap.img_2_foreground));
        // Add more rooms as needed
        return rooms;
    }
}