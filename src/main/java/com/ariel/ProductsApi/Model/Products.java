package com.ariel.ProductsApi.Model;


import com.ariel.ProductsApi.Abstractions.BaseEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity(name="products")
@Table
@Getter
@Setter
@AttributeOverrides({
    @AttributeOverride(name="id", column=@Column(name="products_id"))
})
public class Products extends BaseEntity {

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private int stock;

    public Products(String name, double price, int stock, String createdBy, String updatedBy, boolean status) {
        super(createdBy, updatedBy, status);
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    public Products(){

    }
}
