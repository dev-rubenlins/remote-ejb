package io.dev.ruben.random.ejb;

import javax.ejb.Remote;

@Remote
public interface RandomService {
    String randomString(int length);
}
