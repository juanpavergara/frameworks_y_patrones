package co.com.school.factorymethod_facade;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Component
public class CalculadoraFacade {
	
	@Autowired
	private AbstractCreadorDeProductos creadorAbstracto;
	
	public int ejecutarCalculo(Map<String, BigDecimal> mapa){
		AbstractCalculador c = creadorAbstracto.fabricarProducto();
		int resultado = c.ejecutarCalculo(mapa);
		return resultado;
	}
	

	
}
