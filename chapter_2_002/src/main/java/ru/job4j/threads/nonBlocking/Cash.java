package ru.job4j.threads.nonBlocking;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class Cash {
    private final ConcurrentHashMap<Long, Base> values = new ConcurrentHashMap<>();

    public void add(final Base newBase) {
        this.values.put(newBase.getId(), newBase);
    }

    public void update(final Base newBase) {
        this.values.computeIfPresent(newBase.getId(), new BiFunction<Long, Base, Base>() {
            @Override
            public Base apply(Long id, Base oldBase) {
                if (oldBase.getVersion() == newBase.getVersion()) {
                    oldBase.setName(newBase.getName());
                } else {
                    throw new OptimisticException("version is incorrect!");
                }
                return oldBase;
            }
        });
    }

    public void delete(final Base Base) {
        this.values.remove(Base.getId());
    }
}
