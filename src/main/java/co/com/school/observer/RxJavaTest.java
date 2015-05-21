package co.com.school.observer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.observables.BlockingObservable;
import rx.schedulers.Schedulers;

public class RxJavaTest {
	
	public RxJavaTest(){
	
	}
	
	public void hello(String... names) {
		
		// Se crea un Observable a partir de una estructura de datos.
		// Se suscribe un observador con Action1
	    Observable.from(names)
	    .subscribeOn(Schedulers.computation())
	    .subscribe(new Action1<String>() {
	    	@Override
	        public void call(String s) {
	    		try{Thread.sleep(1000);}catch(Exception e){}
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
	    		try{Thread.sleep(1000);}catch(Exception e){}
	            System.out.println("Obtuve " + s + "!");
	        }
	    });
		
	}
	
	public Observable<String> procesar(){
		Observable<Long> timer = Observable.interval(1, TimeUnit.SECONDS);
		
		ArrayList<String> lista = new ArrayList<String>();
		
		lista.add("Juan");
		lista.add("Pablo");
		lista.add("Vergara");
		
	    Func2<Long, String, String> combine = new Func2<Long, String, String>() {
	        @Override
	        public String call(Long m, String r) {
	            return r;
	        }
	    };
		
		Observable<String> strings1 = Observable.from(lista);			
		
		Observable<String> res1 = timer.zipWith(strings1,  (x, y) -> { return y ;});
		
		Observable<String> res2 = timer.zipWith(strings1,  combine);
		
		return res2;
	} 
	
	public static void main(String[] args) throws Exception{
		RxJavaTest test = new RxJavaTest();
		
		//test.hello("Juan", "Pablo", "Clase", "Frameworks", "Patrones");
		
		Observable<String> o = test.procesar();
		
		Action1<String> accion = new Action1<String>() {
			@Override
			public void call(String t1) {
				System.out.println(t1);				
			}
		}; 
		
		Action1<ArrayList<String>> accionLista = new Action1<ArrayList<String>>() {
			@Override
			public void call(ArrayList<String> t1) {
				System.out.println(t1.get(1));				
			}
		}; 
		
		// o.subscribe(accion);
		
		Observable<String> obs = Observable.just("HOLA", "SHIN");
		
		ArrayList<String> lista = new ArrayList<String>();
		
		lista.add("LIST ELEMENT 1");
		lista.add("LIST ELEMENT 2");
		lista.add("LIST ELEMENT 3");
				
		Observable<ArrayList<String>> listaobs = Observable.just(lista);
		
		obs.subscribe(accion);
		listaobs.subscribe(accionLista);
		
		o.toBlocking().forEach(accion);
		
		//Thread.sleep(10000);
		
	}
}
