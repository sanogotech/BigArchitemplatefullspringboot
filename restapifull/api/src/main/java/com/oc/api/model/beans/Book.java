package com.oc.api.model.beans;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

/**
 * Book
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Le titre doit être renseigné.")
    private String title;

    @NotEmpty(message = "Le prénom de l'auteur doit être renseigné.")
    @Column(name = "author_first_name")
    private String authorFirstName;

    @NotEmpty(message = "Le nom de l'auteur doit être renseigné.")
    @Column(name = "author_last_name")
    private String authorLastName;

    @NotNull
    @PastOrPresent
    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @NotEmpty
    @Length(max = 1000)
    private String synopsis;

    @NotEmpty
    private String pictureURL;

    @JsonIgnore
    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private Set<Borrow> borrows;

    @JsonIgnore
    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private Set<AvailableCopie> availableCopies;

    public Book() {
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Set<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(Set<Borrow> borrows) {
        this.borrows = borrows;
    }

    public Set<AvailableCopie> getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Set<AvailableCopie> availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "Book [authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName + ", availableCopies="
                + availableCopies + ", borrows=" + borrows + ", id=" + id + ", pictureURL=" + pictureURL
                + ", publicationDate=" + publicationDate + ", synopsis=" + synopsis + ", title=" + title + "]";
    }

    

    

    

    
    

    
}