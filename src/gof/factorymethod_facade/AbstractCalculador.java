package gof.factorymethod_facade;

import java.math.BigDecimal;
import java.util.Map;

public abstract class AbstractCalculador {
	public abstract int ejecutarCalculo(Map<String, BigDecimal> mapa);
}
