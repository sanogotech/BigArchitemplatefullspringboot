package com.oc.api.model.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Library
 */
@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @NotEmpty(message = "Le nom de la bibliothèque doit être renseigné.")
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "library", cascade = CascadeType.REMOVE)
    private Set<Borrow> borrows;

    @JsonIgnore
    @OneToMany(mappedBy = "library", cascade = CascadeType.REMOVE)
    private Set<AvailableCopie> availableCopies;

    public Library() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Library [availableCopies=" + availableCopies + ", borrows=" + borrows + ", id=" + id + ", name=" + name
                + "]";
    }

}