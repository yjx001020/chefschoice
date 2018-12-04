package com.example.jessieyang.chefschoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.jessieyang.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final Button startAPICall = findViewById(R.id.startAPICall);
//        startAPICall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View v) {
//                Log.d(TAG, "Start API button clicked");
//                startAPICall();
//            }
//        }
    }

    public void search(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

//    /**
//     * Make an API call.
//     */
//    void startAPICall() {
//        try {
//            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                    Request.Method.GET,
//                    "",
//                    null,
//                    new Response.Listener<JSONObject>() {
//                        @Override
//                        public void onResponse(final JSONObject response) {
//                            Log.d(TAG, response.toString());
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(final VolleyError error) {
//                    Log.w(TAG, error.toString());
//                }
//            });
//            requestQueue.add(jsonObjectRequest);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
