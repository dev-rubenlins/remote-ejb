package dev.io.ruben.random.ejb.client;

import io.dev.ruben.random.ejb.connector.RandomEjbConnector;
import jakarta.validation.constraints.Positive;

import javax.ejb.Stateless;
import javax.naming.NamingException;

@Stateless
public class RandomEjbClient {

    public String randomString(@Positive int length) throws NamingException {
        RandomEjbConnector connector = new RandomEjbConnector();
        return connector.invoke(length);
    }

}
