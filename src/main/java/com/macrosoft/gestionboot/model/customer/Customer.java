package com.macrosoft.gestionboot.model.customer;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=5, max=190)
    private String name;

    @NotNull
    @Size(min = 8, max = 13)
    private String phone;

    @NotNull
    @Email
    @Size(min = 10, max = 190)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 5, max = 190)
    private String location;

    @NotNull
    private String fileName;
	
	
	//mappedBy and how to use them in a one-to-many bidirectional relationship.
	//mappedBy is the name of the association-mapping attribute on the owning side. 
	@OneToMany(mappedBy = "customer")
	private List<PurchaseOrder>  purchaseOrderList;
	
	@OneToOne
	private ShippingInfo shippingInfo;
	
	@OneToOne
	private BillingInfo billingInfo;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
