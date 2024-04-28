package com.example.atddorder.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.atddorder.domain.PendingOrder;
import org.junit.jupiter.api.Test;

class CreateOrderServiceTest {

    private CreateOrderService createOrderService = new CreateOrderServiceImpl();

    @Test
    void createPendingOrderTest() {
        Long productId = 1L;
        int quantity = 2;
        PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);

        assertThat(pendingOrder.getId()).isPositive();
    }
}
