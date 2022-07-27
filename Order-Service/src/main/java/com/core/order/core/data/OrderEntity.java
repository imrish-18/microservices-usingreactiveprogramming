/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.order.core.data;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.core.order.core.model.OrderStatus;

import lombok.Data;

@Data
@Document
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 5313493413859894403L;

    @Id
    
    public String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;
    
    
    private OrderStatus orderStatus;
}
