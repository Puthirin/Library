package com.example.puthirin.library;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.puthirin.library.BookDetailActivity;
import com.example.puthirin.library.Books;
import com.example.puthirin.library.R;

import java.util.ArrayList;

/**
 * Created by dell on 11/7/2017.
 */

public class ListBooksAdapter extends RecyclerView.Adapter<ListBooksAdapter.BookHolder> {

    ArrayList<Books> books;
    Context context;

    public ListBooksAdapter(ArrayList<Books> books) {
        this.books = books;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {  //get layout and return view;
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_adapter, parent, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(final BookHolder holder, final int position) {           //indusoli view
        final Books book = books.get(position);
        holder.bookCover.setImageResource(R.drawable.book);
        holder.bookTitle.setText(book.getTitle());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),BookDetailActivity.class);
//                BookDetail bookDetail = new BookDetail();
//                bookDetail.data(book.getTitle());
                intent.putExtra("title",book.getTitle());
                intent.putExtra("category",book.getCategory());
                intent.putExtra("author",book.getAuthor());
                intent.putExtra("year",book.getYear());
                context.startActivity(intent);
//                Toast.makeText(context, ""+book.getTitle(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder {

        ImageView bookCover;
        TextView bookTitle;

        View view;

        public BookHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            bookCover = (ImageView) itemView.findViewById(R.id.book_cover);
//            bookCover.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    for (int i=0;i<10;i++) {
//                    Toast.makeText(context, "Hello " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
//
//                }
//            });
            bookTitle = (TextView) itemView.findViewById(R.id.book_title);
        }
    }
}
