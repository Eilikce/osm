package com.eilikce.osm.api.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class OsmApi
{
    public static void main( String[] args )
    {
    	SpringApplication.run(OsmApi.class, args);
        System.out.println( "Osm Api Respository Start!" );
    }
}
