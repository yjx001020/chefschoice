package com.example.jessieyang.chefschoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class DisplayMessageActivity extends AppCompatActivity {
    private TextView resultshown;
    private boolean resultFound = true;

    void jsonParse(JSONObject jsonObject) {
        try {
            String count = jsonObject.getString("count");
            String recipes = jsonObject.getString("recipes");
            String title = jsonObject.getString("title");
        } catch (Exception e) {
            resultFound = false;
        }
        if (!resultFound) {
            resultshown.setText("Here is the recipes:");
        } else {
            resultshown.setText("No Recipes Found");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);


    }
}
