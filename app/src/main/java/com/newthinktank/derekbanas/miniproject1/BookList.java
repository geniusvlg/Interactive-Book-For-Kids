package com.newthinktank.derekbanas.miniproject1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;


public class BookList extends ActionBarActivity {
    private List<Book> myBooks = new ArrayList<Book>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);
        populateBookList();
        populateListView();
        registerClickCallback();

    }

    private void populateBookList() {
        myBooks.add(new Book("Harry Potter and the Sorcerer's Stone", R.drawable.one));
        myBooks.add(new Book("Harry Potter And The Chamber Of Secrets", R.drawable.two));
        myBooks.add(new Book("Harry Potter and the Prisoner of Azkaban ", R.drawable.three));
        myBooks.add(new Book("Harry Potter And The Goblet Of Fire ", R.drawable.four));
        myBooks.add(new Book("Harry Potter And The Order Of The Phoenix", R.drawable.five));
        myBooks.add(new Book("Harry Potter and the Half-Blood Prince ", R.drawable.six));
        myBooks.add(new Book("Harry Potter and the Deathly Hallows", R.drawable.seven));
    }

    private void populateListView() {
        ArrayAdapter<Book> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked,
                                    int position, long id) {
                Intent goToPageList = new Intent(BookList.this,PageList.class);
                goToPageList.putExtra("bookNumber",position);
                startActivity(goToPageList);
            }
        });
    }


    private class MyListAdapter extends ArrayAdapter<Book> {
        public MyListAdapter() {
            super(BookList.this, R.layout.book_view,myBooks);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View bookView = convertView;
            if(bookView == null){
                bookView = getLayoutInflater().inflate(R.layout.book_view,parent, false);
            }

            Book currentBook = myBooks.get(position);

            ImageView imageView = (ImageView) bookView.findViewById(R.id.book_icon);
            imageView.setImageResource(currentBook.getBookIcon());

            TextView bookText = (TextView) bookView.findViewById(R.id.book_name);
            bookText.setText(currentBook.getBookName());
            return bookView;
        }
    }

}
