package com.example.jessieyang.chefschoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.jessieyang.MESSAGE";
    private static final String TAG = "chefschoice";
    private static final String API_KEY = "d6ab99096385e79634e00142feb80e9e";
    private String message;
    private int pagecount = 1;
//    private TextView result = findViewById(R.id.textView4);
    private boolean resultFound = true;

    /** Request queue for our network requests. */
    private static RequestQueue requestQueue;

    /**
     * Run when our activity comes into view.
     *
     * @param savedInstanceState state that was saved by the activity last time it was paused
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up a queue for our Volley requests
        requestQueue = Volley.newRequestQueue(this);

        // Load the main layout for our activity
        setContentView(R.layout.activity_main);

        // Attach the handler to our UI button
        final Button startAPICall = findViewById(R.id.button);
        startAPICall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Start API button clicked");
                startAPICall();
            }
        });
    }

    public void search(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    void startAPICall() {
        /**
         * Make an API call
         */
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://www.food2fork.com/api/search?key=" + API_KEY + "&q=" + message + "&page=" + pagecount,
                    message,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            Log.d("This is the response", response.toString());

//                            JSONObject result = jsonParse(response.toString()).getAsJsonObject();
//                            JSONArray recipe = result.get("recipes").getAsJsonArray();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.w(TAG, error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void jsonParse(JSONObject jsonObject) {
        try {
            String count = jsonObject.getString("count");
            String recipes = jsonObject.getString("recipes");
            String title = jsonObject.getString("title");
        } catch (Exception e) {
            resultFound = false;
        }
//        if (!resultFound) {
//            result.setText("Here_is_the_recipes:");
//        } else {
//            result.setText("No Recipes Found");
//        }
    }
}
//https://www.food2fork.com/api/search?key=d6ab99096385e79634e00142feb80e9e&q=chicken%20breast&page=2
//https://www.food2fork.com/api/search?key=d6ab99096385e79634e00142feb80e9e&q=null&page=1