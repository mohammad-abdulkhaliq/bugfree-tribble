package controller;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.SpringBootServletInitializer;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.ArrayList;

public class MyPasswordWebXml extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}