package org.acme.kafka.fruit;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fruits")
public class FruitResource {

    private static final Logger log = LoggerFactory.getLogger(FruitResource.class);

    @Inject
    @Channel("fruit-out")
    Publisher<Fruit> fruits;

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType(MediaType.APPLICATION_JSON)
    public Publisher<Fruit> stream() {
        log.info("Stream...");
        return fruits;
    }

}
