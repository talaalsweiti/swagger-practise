package com.exalt.tasks.springboot.person;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs //enables SOAP Web Service features in this Spring Boot application.
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    private static final String NAME_SPACE="http://localhost:8080";
    private static final String URL="/soap";

    /*
    messageDispatcherServlet is used for handling SOAP requests
     */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, URL+"/*");
    }
    @Bean(name = "person")
    public DefaultWsdl11Definition defaultWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PersonPort");
        wsdl11Definition.setLocationUri(URL+"/person");
        wsdl11Definition.setTargetNamespace(NAME_SPACE);
//       wsdl11Definition.setSchema(personSchema);
        return wsdl11Definition;
    }
//
//    @Bean
//    public XsdSchema personSchema() {
//        return new SimpleXsdSchema(new ClassPathResource(Person.class.getPa));
//    }

}
