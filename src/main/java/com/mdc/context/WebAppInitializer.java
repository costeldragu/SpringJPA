package com.mdc.context;

import com.mdc.config.JavaConfig;
import com.mdc.config.JpaConfig;
import com.mdc.config.WebMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Register DispatcherServlet
        super.onStartup(servletContext);

        //Hibernate need this to create innodb tables on system property
        System.setProperty("hibernate.dialect.storage_engine", "innodb");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{JavaConfig.class, JpaConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
