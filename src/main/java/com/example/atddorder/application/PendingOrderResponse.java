package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;
import lombok.Getter;

@Getter
public class PendingOrderResponse {

    private long id;
    private long productId;
    private int quantity;

    public PendingOrderResponse(PendingOrder pendingOrder) {
        this.id = pendingOrder.getId();
        this.productId = pendingOrder.getProductId();
        this.quantity = pendingOrder.getQuantity();
    }
}
