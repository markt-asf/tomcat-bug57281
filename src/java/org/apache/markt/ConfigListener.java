package org.apache.markt;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConfigListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Filter f = new NoopFilter();

        FilterRegistration.Dynamic reg = sce.getServletContext().addFilter("noop", f);
        reg.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // NO-OP
    }
}
