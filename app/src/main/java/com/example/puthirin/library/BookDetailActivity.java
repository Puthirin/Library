package com.example.puthirin.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    Button borrow;
    final String URL_borrow = "http://192.168.0.113:800/borrow";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        title = (TextView) findViewById(R.id.title_d);
        author=(TextView) findViewById(R.id.author_d);
        type = (TextView) findViewById(R.id.type_d);
        description = (TextView) findViewById(R.id.text_dis);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

//        title.setText(bundle.getString("author"));
        title.setText(bundle.getString("title"));
        author.setText(bundle.getString("author"));
        type.setText(bundle.getString("category"));
        Toast.makeText(this, bundle.getString("author"), Toast.LENGTH_SHORT).show();
        borrow = (Button)findViewById(R.id.borrow);
        
        borrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        
    }

    private void submit() {
    }
}
