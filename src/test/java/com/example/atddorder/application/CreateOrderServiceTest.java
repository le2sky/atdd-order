package com.example.atddorder.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicLong;
import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.domain.PendingOrderRepository;
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

    private static class CreateOrderServiceImpl implements CreateOrderService {

        private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();

        @Override
        public PendingOrder createPendingOrder(PendingOrderRequest request) {
            PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
            pendingOrder = pendingOrderRepository.save(pendingOrder);

            return pendingOrder;
        }
    }

    private static class PendingOrderRepositoryMemoryImpl implements PendingOrderRepository {

        private AtomicLong atomicId = new AtomicLong(1);

        @Override
        public PendingOrder save(PendingOrder pendingOrder) {
            pendingOrder.assignId(nextId());
            return pendingOrder;
        }

        private long nextId() {
            return atomicId.getAndIncrement();
        }
    }
}
