package gof.observer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

public class RxJavaTest {
	
	public RxJavaTest(){
	
	}
	
	public void hello(String... names) {
		
		// Se crea un Observable a partir de una estructura de datos.
		// Se suscribe un observador con Action1
	    Observable.from(names).subscribe(new Action1<String>() {
	    	@Override
	        public void call(String s) {
	            System.out.println("Hello " + s + "!");
	        }
	    });
	    	    
	}
	
	public void interval(){
		
		// Crea un observable que emite eventos cada unidad de tiempo establecida
		Observable<Long> obs = Observable.interval(1, TimeUnit.SECONDS);
		
		// Se suscribe un observador con Action1
		obs.subscribe(new Action1<Long>() {
	    	@Override
	        public void call(Long s) {
	            System.out.println("Obtuve " + s + "!");
	        }
	    });
		
	}
	
	public static void main(String[] args) throws Exception{
		RxJavaTest test = new RxJavaTest();
		
		test.hello("Juan", "Pablo", "Clase", "Frameworks", "Patrones");
		
		test.interval();		
		
		Thread.sleep(10000);
		
	}
}
