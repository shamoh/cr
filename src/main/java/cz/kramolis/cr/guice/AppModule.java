package cz.kramolis.cr.guice;

import com.google.inject.AbstractModule;
import cz.kramolis.cr.config.Secrets;
import cz.kramolis.cr.config.SecretsProvider;

import javax.inject.Singleton;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Secrets.class).toProvider(SecretsProvider.class).in(Singleton.class);
    }

}
