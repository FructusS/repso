package com.example.javaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class coffee_house_activity extends AppCompatActivity {
    ImageButton imageButton;
    Button businessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_house);
        imageButton = findViewById(R.id.buttonCoffeehouseBack);
        businessButton = findViewById(R.id.businessButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),coffee_house_activity.class);
                startActivity(intent);
            }
        });
        businessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), search_building.class);
                startActivity(intent);
            }
        });
    }

}