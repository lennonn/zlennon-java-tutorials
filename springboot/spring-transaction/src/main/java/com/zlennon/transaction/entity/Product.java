package com.zlennon.transaction.entity;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRODUCTS")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "PRICE")
    private Integer price;

}
