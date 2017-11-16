package com.example.puthirin.library;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;


import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.puthirin.library.Books;
import com.example.puthirin.library.MainActivity;
import com.example.puthirin.library.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class ListBooksActivity extends AppCompatActivity {

    RecyclerView listBooks;
    final String URL_get = "http://192.168.100.105:8000/book_get";
    static ArrayList<Books> books = new ArrayList<>();

//    static {
//        books.add(new Books(1, "Mathematic", "", ""));
//        books.add(new Books(1, "Mathematic1", "", ""));
//        books.add(new Books(1, "Mathematic2", "", ""));
//        books.add(new Books(1, "Mathematic3", "", ""));
//        books.add(new Books(1, "Mathematic4", "", ""));
//        books.add(new Books(1, "Mathematic5", "", ""));
//        books.add(new Books(1, "Mathematic6", "", ""));
//        books.add(new Books(1, "Mathematic7", "", ""));
//    }

    public int convertDipToPixels(float dips)
    {
        return (int) (dips * this.getResources().getDisplayMetrics().density + 0.5f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);

        int colNum = (int) getWindow().getWindowManager().getDefaultDisplay().getWidth()/convertDipToPixels(105);

        listBooks = (RecyclerView) findViewById(R.id.list_books);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, colNum);
        listBooks.setLayoutManager(gridLayoutManager);
        listBooks.setItemAnimator(new DefaultItemAnimator());
        listBooks.setHasFixedSize(true);
        final ListBooksAdapter listBooksAdapter = new ListBooksAdapter(books);
        listBooks.setAdapter(listBooksAdapter);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_get, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
//                Toast.makeText(ListBooksActivity.this, ""+jsonObjectRequest.toString("title"), Toast.LENGTH_SHORT).show();
                try {
                    JSONArray array = jsonObject.getJSONArray("data");
//                    Log.d("data","");
                    Toast.makeText(ListBooksActivity.this, ""+array.getJSONObject(0).getString("title"), Toast.LENGTH_SHORT).show();
                    for (int i=array.length()-1;i>=0;i--){
                        books.add(new Books(1,array.getJSONObject(i).getString("title"),array.getJSONObject(i).getString("category"),array.getJSONObject(i).getString("author"),array.getJSONObject(i).getString("year")));
//                        Log.d("books","");
//                        books.add(new Books())

                    }

                    listBooksAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(ListBooksActivity.this, volleyError.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObjectRequest);


    }

    @Override
    public void onBackPressed() {
        books = new ArrayList<>();
        super.onBackPressed();
    }
}
