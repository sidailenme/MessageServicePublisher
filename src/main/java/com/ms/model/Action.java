package com.ms.model;

import java.util.Random;

public enum Action {
    PURCHASE,
    SUBSCRIPTION;

    private static final Action[] VALUES = Action.values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Action randomAction() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
