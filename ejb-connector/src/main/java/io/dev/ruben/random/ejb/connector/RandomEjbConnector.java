package io.dev.ruben.random.ejb.connector;

import io.dev.ruben.random.ejb.RandomService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

import static java.lang.String.format;

public class RandomEjbConnector {

    private String randomEjbHost = System.getenv("RANDOM_EJB_HOST");
    private String randomEjbPort = System.getenv("RANDOM_EJB_PORT");

    public String invoke(int randomStringLength) throws NamingException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        props.put(Context.PROVIDER_URL, format("http-remoting://%s:%s",randomEjbHost,randomEjbPort));

        Context context = new InitialContext(props);
        RandomService randomService = (RandomService) context.lookup("ejb:/remote-ejb-server-1.0-SNAPSHOT/RandomEjbService!dev.io.ruben.ejb.server.RandomService");
        return randomService.randomString(randomStringLength);
    }

}
