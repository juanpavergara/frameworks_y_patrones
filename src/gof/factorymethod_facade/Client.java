package gof.factorymethod_facade;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CreadorCalculadorUno.class);
		CalculadoraFacade cliente = context.getBean(CalculadoraFacade.class);
		Map<String, BigDecimal> mapa = new HashMap<String, BigDecimal>();
		mapa.put("1", new BigDecimal(1));
		mapa.put("2", new BigDecimal(2));
		mapa.put("3", new BigDecimal(3));
		int resultado = cliente.ejecutarCalculo(mapa);
		System.out.println("resultado: " + resultado);
	}
}
