package com.domain.lesson25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(atomicInteger::incrementAndGet);
        atomicInteger.compareAndSet(2,5); //предполагает и устанавливает
        atomicInteger.updateAndGet(operand -> operand + 90); //елси несколько потоков - потокобезопасная
    }
}
