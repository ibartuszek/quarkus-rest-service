package org.acme.kafka.fruit;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Fruit {

    public String name;
    public int price;

    public Fruit() {}

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
