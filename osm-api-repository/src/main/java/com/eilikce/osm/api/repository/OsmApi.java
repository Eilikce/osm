package com.eilikce.osm.api.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.eilikce.osm.api.repository.*"})
public class OsmApi
{
    public static void main( String[] args )
    {
    	SpringApplication.run(OsmApi.class, args);
        System.out.println( "Hello World!" );
    }
}
