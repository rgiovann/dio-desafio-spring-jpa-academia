package dio.desafio.academia.spring.jpa.expanded.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    
    @Bean 
    Utilities utilities() {
    	return Utilities.getInstancia();
    }

}