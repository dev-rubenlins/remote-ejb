package dev.io.ruben.ejb.server;


import io.dev.ruben.random.RandomStrings;
import io.dev.ruben.random.ejb.RandomService;
import jakarta.validation.constraints.Positive;

import javax.ejb.Stateless;

@Stateless
public class RandomEjbService implements RandomService {

   private org.jboss.

    @Override
    public String randomString(@Positive int length){
        return RandomStrings.generateRandomString(length);
    }

}
