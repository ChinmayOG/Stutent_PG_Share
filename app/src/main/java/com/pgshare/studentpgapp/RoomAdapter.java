package com.pgshare.studentpgapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {

    private List<Room> roomList;

    public RoomAdapter(List<Room> roomList) {
        this.roomList = roomList;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.roomlist, parent, false);
        return new RoomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room room = roomList.get(position);


        Glide.with(holder.itemView.getContext())
                .load(room.getImageResourceId())
                .placeholder(R.drawable.default_room_image)  // Placeholder image while loading
                .into((ImageView) holder.roomImageView);
        holder.roomNameTextView.setText(room.getRoomName());
        holder.locationTextView.setText(room.getLocation());
        holder.priceTextView.setText(String.valueOf(room.getPrice()));
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    static class RoomViewHolder extends RecyclerView.ViewHolder {
        public Object roomImageView;
        TextView roomNameTextView;
        TextView locationTextView;
        TextView priceTextView;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            roomImageView= itemView.findViewById(R.id.roomImageView);
            roomNameTextView = itemView.findViewById(R.id.roomNameTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
        }
    }
}
