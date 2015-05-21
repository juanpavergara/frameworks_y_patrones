package co.com.school.factorymethod_facade;

import java.math.BigDecimal;
import java.util.Map;

public class CalculadorUno extends AbstractCalculador{
	public int ejecutarCalculo(Map<String, BigDecimal> mapa){
		int resultado = 0;
		for(String k: mapa.keySet()){
			resultado += mapa.get(k).toBigInteger().intValue();
		}
		return resultado;
	}
}
