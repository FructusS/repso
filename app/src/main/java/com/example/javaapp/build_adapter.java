package com.example.javaapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class build_adapter extends RecyclerView.Adapter<build_adapter.MyViewClass> {
        ArrayList<String> title;
//    ArrayList<String> cost;
//    ArrayList<String> street;
//    ArrayList<String> metro;
//    ArrayList<String> description;
//    ArrayList<String> imageList;
//
//    ArrayList<Double> coords1;
//    ArrayList<Double> coords2;
    List<Buildings> buildings;
    Context context;

    public build_adapter(List<Buildings> buildings,
                         Context context) {
        this.buildings = buildings;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.build_row, parent, false);
        MyViewClass myViewClass = new MyViewClass(v);
        return myViewClass;
    }

    @Override
    public void onBindViewHolder(@NonNull build_adapter.MyViewClass holder, int position) {

        final int pos = position;
        holder.title.setText(buildings.get(position).getTitle());
        holder.cost.setText(buildings.get(position).getCost()  + " ₽ в мес.");
        holder.street.setText(buildings.get(position).getStreet());
        holder.metro.setText(buildings.get(position).getMetro());
        Picasso.with(context).load(buildings.get(position).getImage()).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), build_info.class);
                intent.putExtra("title", buildings.get(pos).getTitle());
                intent.putExtra("cost", buildings.get(pos).getCost());
                intent.putExtra("street", buildings.get(pos).getStreet());
                intent.putExtra("metro", buildings.get(pos).getMetro());
                intent.putExtra("descr", buildings.get(pos).getDescription());
                intent.putExtra("coords1", buildings.get(pos).getCoords1());
                intent.putExtra("coords2", buildings.get(pos).getCoords2());
                intent.putExtra("image", buildings.get(pos).getImage());
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return buildings.size();
    }

    public class MyViewClass extends RecyclerView.ViewHolder {
        TextView title;
        TextView cost;
        TextView street;
        TextView metro;
        ImageView image;

        public MyViewClass(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            cost = itemView.findViewById(R.id.cost);
            street = itemView.findViewById(R.id.street);
            metro = itemView.findViewById(R.id.metro);
            image = itemView.findViewById(R.id.imageBuildrow);

        }
    }
}
