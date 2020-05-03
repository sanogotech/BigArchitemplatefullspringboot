package com.macrosoft.gestionboot.model.customer;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Myproduct")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    //@Column
    @NotNull
    @Size(min=2, max=30)
    private String numberProduct;

    //@Column
    @NotNull
    @Size(min=10, max=50)
    private String name;

    //@Column
    @NotNull
    @Min(3)
    private Integer price;

    //@Column
    @NotNull
    @Size(min=20, max=500)
    private String description;
	

	private String brand;
	private String madein;

	
	private Boolean available;

	
	@ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
	/*
	 * @JoinColumn indicates the entity is the owner of the relationship: 
	 * the corresponding table has a column with a foreign key to the referenced table.
	 */
	
	@OneToMany(mappedBy ="product")
	private List<OrderLineItem>  orderLineItemList;
	
	@ManyToOne
	private Supplier supplier;

    public String getNumberProduct() {
        return numberProduct;
    }

    public void setNumberProduct(String numberProduct) {
        this.numberProduct = numberProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public List<OrderLineItem> getOrderLineItemList() {
		return orderLineItemList;
	}

	public void setOrderLineItemList(List<OrderLineItem> orderLineItemList) {
		this.orderLineItemList = orderLineItemList;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
    
    
}
