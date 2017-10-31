package cz.kramolis.cr.guice;

import com.google.inject.servlet.ServletModule;
import cz.kramolis.cr.rest.FetchClanStatsServlet;

import javax.inject.Singleton;

public class RestModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(FetchClanStatsServlet.class).in(Singleton.class);

        serve("/fetch").with(FetchClanStatsServlet.class);
    }
}
