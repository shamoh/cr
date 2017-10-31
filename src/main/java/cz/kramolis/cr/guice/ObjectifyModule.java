package cz.kramolis.cr.guice;

import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFilter;
import cz.kramolis.cr.domain.ClanEntity;
import cz.kramolis.cr.domain.MemberEntity;

import javax.inject.Singleton;

import static com.googlecode.objectify.ObjectifyService.register;

public class ObjectifyModule extends ServletModule {

    static {
        register(ClanEntity.class);
        register(MemberEntity.class);
    }

    @Override
    protected void configureServlets() {
        bind(ObjectifyFilter.class).in(Singleton.class);
        filter("/*").through(ObjectifyFilter.class);
    }
}
