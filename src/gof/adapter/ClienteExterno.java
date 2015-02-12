package gof.adapter;

import gof.factorymethod_facade.CreadorCalculadorUno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ClienteExterno {
	
	@Autowired
	private ICalculadoraAdapter calc;
	
	public int calcularLegado(int... enteros){
		return calc.ejecutarCalculo(enteros);
	}
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AdapterFactory.class, CreadorCalculadorUno.class);
		ClienteExterno cliente = context.getBean(ClienteExterno.class);
		
		int resultado = cliente.calcularLegado(1, 2, 3, 4);
		System.out.println("resultado: " + resultado);
		
		resultado = cliente.calcularLegado(2,4,6);
		System.out.println("resultado: " + resultado);
		
	}
}
