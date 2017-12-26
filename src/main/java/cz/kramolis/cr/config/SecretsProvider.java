package cz.kramolis.cr.config;

import javax.inject.Provider;
import java.io.IOException;
import java.util.Properties;

public class SecretsProvider implements Provider<Secrets> {

    @Override
    public Secrets get() {
        Properties props = new Properties();
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("secrets.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Secrets.builder()
                .crApiAuthHeader(props.getProperty("cr-api.auth"))
                .build();
    }

}
