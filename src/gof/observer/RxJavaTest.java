package gof.observer;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

public class RxJavaTest {
	
	
	public static void hello(String... names) {
	
	    Observable.from(names).subscribe(new Action1<String>() {
	    	@Override
	        public void call(String s) {
	            System.out.println("Hello " + s + "!");
	        }
	    });
	    	    
	}
	
	public static void interval(){
		
		Observable<Long> obs = Observable.interval(1, TimeUnit.SECONDS);
		
		obs.subscribe(new Action1<Long>() {
	    	@Override
	        public void call(Long s) {
	            System.out.println("Obtuve " + s + "!");
	        }
	    });
		
	}
	
	public static void main(String[] args) throws Exception{
		hello("Juan", "Pablo");
		
		interval();
		
		Thread.sleep(10000);
		
	}
}
