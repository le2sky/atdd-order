package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;

interface CreateOrderService {

    PendingOrder createPendingOrder(PendingOrderRequest request);
}
