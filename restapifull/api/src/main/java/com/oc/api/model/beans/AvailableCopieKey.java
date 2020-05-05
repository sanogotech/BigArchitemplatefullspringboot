package com.oc.api.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * AvailableCopieKey
 */
@Embeddable
public class AvailableCopieKey implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "book_id")
    private int bookId;
    
    @NotNull
    @Column(name = "library_id")
    private int libraryId;

    public AvailableCopieKey() {
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bookId;
        result = prime * result + libraryId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AvailableCopieKey other = (AvailableCopieKey) obj;
        if (bookId != other.bookId)
            return false;
        if (libraryId != other.libraryId)
            return false;
        return true;
    }

    


    

}