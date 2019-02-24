package com.eilikce.osm.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.eilikce.osm.dao")
@ComponentScan(basePackages = {"com.eilikce.osm"})
public class OsmAdmin {
    public static void main(String[] args) {
        SpringApplication.run(OsmAdmin.class, args);
    }
}
