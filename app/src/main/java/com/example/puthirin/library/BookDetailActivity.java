package com.example.puthirin.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class BookDetailActivity extends AppCompatActivity {
    TextView title,author,type,description;
    final static String URL_detail="http://192.168.100.105:8000/book_get";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        title = (TextView) findViewById(R.id.title_d);
        author=(TextView) findViewById(R.id.author_d);
        type = (TextView) findViewById(R.id.type_d);
        description = (TextView) findViewById(R.id.text_dis);
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL_detail, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray array = object.getJSONArray("data");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });


    }
}
