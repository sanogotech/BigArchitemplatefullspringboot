package com.oc.webapp.model.beans;

/**
 * AvailableCopieKeyBean
 */
public class AvailableCopieKeyBean {

    private int bookId;
    private int libraryId;

    public AvailableCopieKeyBean() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String toString() {
        return "AvailableCopieKeyBean [bookId=" + bookId + ", libraryId=" + libraryId + "]";
    }
    
    
    

    
}