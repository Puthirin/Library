package com.example.puthirin.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewBookActivity extends AppCompatActivity {
    private ViewStub stubGrid;
    private GridView gridView;
    private GridViewAdapter gridViewAdapter;
    private List<Books> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);

        stubGrid = (ViewStub) findViewById(R.id.stub_grid);
        stubGrid.inflate();

        gridView = (GridView) findViewById(R.id.mygridview);

        getBookList();
    }

    public List<Books> getBookList(){
        list = new ArrayList<>();
        list.add(new Books(R.drawable.icon_android,"Book 1", "This is Description"));
        list.add(new Books(R.drawable.icon_android,"Book 1", "This is Description"));
        list.add(new Books(R.drawable.icon_android,"Book 1", "This is Description"));
        list.add(new Books(R.drawable.icon_android,"Book 1", "This is Description"));
        list.add(new Books(R.drawable.icon_android,"Book 1", "This is Description"));
        list.add(new Books(R.drawable.icon_android,"Book 1", "This is Description"));
        list.add(new Books(R.drawable.icon_android,"Book 1", "This is Description"));
        list.add(new Books(R.drawable.icon_android,"Book 1", "This is Description"));

        return list;
    }
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(NewBookActivity.this,BookDetailActivity.class);
            TextView textView = (TextView) findViewById(R.id.title);
            String message = list.get(position).getTitle();
            intent.putExtra("String i need", message);
            startActivity(intent);
        }
    };


}
