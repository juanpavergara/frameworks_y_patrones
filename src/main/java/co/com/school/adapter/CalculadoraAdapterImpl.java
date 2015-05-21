package co.com.school.adapter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import co.com.school.factorymethod_facade.CalculadoraFacade;
import co.com.school.factorymethod_facade.CreadorCalculadorUno;

public class CalculadoraAdapterImpl implements ICalculadoraAdapter {

	CalculadoraFacade fachada;
	
	public CalculadoraAdapterImpl(){
		ApplicationContext context = new AnnotationConfigApplicationContext(CreadorCalculadorUno.class);
		fachada = context.getBean(CalculadoraFacade.class);	
	}
	
	@Override	
	public int ejecutarCalculo(int... enteros) {
		Map<String, BigDecimal> mapa = new HashMap<String, BigDecimal>();
		for(int i: enteros){
			mapa.put(Integer.toString(i), new BigDecimal(i));
		}
		return fachada.ejecutarCalculo(mapa);
		
	}

}
