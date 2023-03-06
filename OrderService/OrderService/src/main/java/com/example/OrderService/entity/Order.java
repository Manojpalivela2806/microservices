package com.example.OrderService.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    @Id
    private int id;
    private String name;
    private int quantity;
    private double price;
}
