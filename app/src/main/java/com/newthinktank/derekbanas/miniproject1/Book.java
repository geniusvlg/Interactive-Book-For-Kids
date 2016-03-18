package com.newthinktank.derekbanas.miniproject1;

/**
 * Created by Huy on 6/28/2015.
 */
public class Book {
    private String bookName;
    private int bookIcon;

    public Book(String bookName, int bookIcon)
    {
        this.bookName=bookName;
        this.bookIcon=bookIcon;
    }

    public String getBookName(){
        return bookName;
    }

    public int getBookIcon(){
        return bookIcon;
    }
}
