package com.example.javaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class search_building extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Buildings> buildings = new ArrayList<Buildings>() {
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_building);
        recyclerView  = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            JSONObject jsonObject = new JSONObject(JsonDataFromAsset("build.json"));
            JSONArray jsonArray = jsonObject.getJSONArray("build");
            for(int i =0;i<jsonArray.length();i++){
                JSONObject userData = jsonArray.getJSONObject(i);
                String title = userData.getString("title");
                String cost = userData.getString("cost");
                String street = userData.getString("street");
                String metro = userData.getString("metro");
                String description = userData.getString("description");
                String image = userData.getString("image");
                Double coords1 = userData.getDouble("coords1");
                Double coords2 = userData.getDouble("coords2");
                buildings.add(new Buildings(title,cost,street,metro,description,image,coords1,coords2));

            }
        }catch (JSONException e){
            e.printStackTrace();

        }
        build_adapter buildAdapter = new build_adapter(buildings,search_building.this);
        recyclerView.setAdapter(buildAdapter);
    }

    private String JsonDataFromAsset(String fileName) {
        String json = null;
        try{
            InputStream inputStream = getAssets().open(fileName);
            int sizeofFile = inputStream.available();
            byte[] buffer = new byte[sizeofFile];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer,"UTF-8");


        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return  json;
    }



}