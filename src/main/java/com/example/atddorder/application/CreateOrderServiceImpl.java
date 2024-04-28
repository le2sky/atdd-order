package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.domain.PendingOrderRepository;
import com.example.atddorder.infra.PendingOrderRepositoryMemoryImple;

class CreateOrderServiceImpl implements CreateOrderService {

    private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImple();

    @Override
    public PendingOrder createPendingOrder(PendingOrderRequest request) {
        PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
        pendingOrder = pendingOrderRepository.save(pendingOrder);

        return pendingOrder;
    }
}
