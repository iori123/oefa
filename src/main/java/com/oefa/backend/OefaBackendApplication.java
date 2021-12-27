package com.oefa.backend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication

//public class OefaBackendApplication extends SpringBootServletInitializer {
public class OefaBackendApplication  {

	private static  Logger logger = LogManager.getLogger(OefaBackendApplication.class.getName());

	//@Override
	//protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	//	return application.sources(OefaBackendApplication.class);
	//}
	public static void main(String[] args) {
		SpringApplication.run(OefaBackendApplication.class, args);
	}


}
