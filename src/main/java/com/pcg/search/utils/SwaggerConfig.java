package com.pcg.search.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




//@EnableSwagger2
public class SwaggerConfig 
{}
	/**
	@Bean
	public Docket api()
	{
		/**
		return new Docket(DocumentationType.SWAGGER_2)  
        .select()                                  
        .apis(RequestHandlerSelectors.any())              
        .paths(PathSelectors.any())                          
        .build();
        
		return new Docket(DocumentationType.SWAGGER_2)  
        .select()                                  
        .apis(RequestHandlerSelectors.basePackage("com.pcg.search.api.controllers"))              
        .paths(PathSelectors.ant("/api/query/*"))                          
        .build();
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("Niklas Heidloff")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
}
	*/