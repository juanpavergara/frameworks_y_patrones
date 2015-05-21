package co.com.school.adapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AdapterFactory {
	@Bean
	public static ICalculadoraAdapter newCalculadorAdapter(){
		return new CalculadoraAdapterImpl();
	} 
}
