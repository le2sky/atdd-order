package com.example.atddorder.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.domain.PendingOrderRepository;
import com.example.atddorder.infra.PendingOrderRepositoryMemoryImpl;
import org.junit.jupiter.api.Test;

class CreateOrderServiceTest {

    private final PendingOrderRepository repository = new PendingOrderRepositoryMemoryImpl();
    private final CreateOrderService createOrderService = new CreateOrderServiceImpl(repository);

    @Test
    void createPendingOrderTest() {
        Long productId = 1L;
        int quantity = 2;
        PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);

        assertThat(pendingOrder.getId()).isPositive();
    }
}
