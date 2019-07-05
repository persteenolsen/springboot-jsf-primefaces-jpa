package com.persteenolsen.springbootjsfprimefacesjpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WelcomePageRedirect implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {

    // Request from the top of the domain
    registry.addViewController("/")
        .setViewName("forward:/listpersons.xhtml");

    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

  }
}