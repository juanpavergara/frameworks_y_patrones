package co.com.school.factorymethod_facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class CreadorCalculadorUno extends AbstractCreadorDeProductos {
	
	@Override
	@Bean
	public AbstractCalculador fabricarProducto(){
		return new CalculadorUno();
	}
}
