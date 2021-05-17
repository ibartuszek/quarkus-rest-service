package org.acme.kafka.fruit;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitProcessor {

    private static final double CONVERSION_RATE = 0.88;
    private static final Logger log = LoggerFactory.getLogger(FruitProcessor.class);

    @Incoming("fruit-in")
    @Outgoing("fruit-out")
    @Broadcast
    public Fruit process(Fruit fruit) {
        log.info("New fruit is under processing name={} original price={}", fruit.name, fruit.price);
        fruit.price = (int) (fruit.price * CONVERSION_RATE);
        return fruit;
    }

}
