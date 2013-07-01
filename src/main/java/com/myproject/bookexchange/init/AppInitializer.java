package com.myproject.bookexchange.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
    dispatcherContext.scan("com.myproject.bookexchange.configuration");
    ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
    dispatcherServlet.setLoadOnStartup(1);
    dispatcherServlet.addMapping("/");
  }

}
