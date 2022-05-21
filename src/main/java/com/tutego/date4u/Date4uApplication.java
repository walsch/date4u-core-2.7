package com.tutego.date4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync
public class Date4uApplication {

  public static void main( String[] args ) {
    ApplicationContext ctx = SpringApplication.run( Date4uApplication.class, args );
  }

}
