package com.matias.springboot.backend.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//documentacion por swagger /configuration señala que es una clase de docuemntacion y enableswagger habilita  el swagger 
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				//inicia un build 
				.select()
				//seleccionamos que clases vamos a documentar /pueden ser any o el contenedor de paquete 
				.apis(RequestHandlerSelectors.basePackage("com.matias.springboot.backend.apirest.rest"))
				//seleccionamos que path vamos a docuementar 
				.paths(PathSelectors.any())
				//contruimos la documentacion 
				.build();
	}

}
