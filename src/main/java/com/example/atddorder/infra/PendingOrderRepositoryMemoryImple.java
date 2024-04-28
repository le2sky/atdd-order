package com.example.atddorder.infra;

import java.util.concurrent.atomic.AtomicLong;
import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.domain.PendingOrderRepository;

public class PendingOrderRepositoryMemoryImple implements PendingOrderRepository {

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
