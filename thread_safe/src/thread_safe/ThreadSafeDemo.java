package thread_safe;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadSafeDemo{

	public static void SimpleDateFormatDefault() throws Exception {
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");

		Callable<Date> task = new Callable<Date>(){
			public Date call() throws Exception {
				return format.parse("20170323");
			}
		};

		//uzycie 5 watkow jednoczesnie
		ExecutorService exec = Executors.newFixedThreadPool(5);
		List<Future<Date>> results = new ArrayList<Future<Date>>();

		//testowe 20 konwersji
		for(int i = 0 ; i < 20 ; i++){
			results.add(exec.submit(task));
		}
		exec.shutdown();

		for(Future<Date> result : results){
			System.out.println(result.get());
		}
	}
	
	public static void SimpleDateFormatThreadSafe() throws Exception {
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");

		Callable<Date> task = new Callable<Date>(){
			public Date call() throws Exception {
				//najprostsza metoda zabezpieczenia przed nakladaniem sie watkow
				synchronized(format){
					return format.parse("20170323");
				}
			}
		};

		//uzycie 5 watkow jednoczesnie
		ExecutorService exec = Executors.newFixedThreadPool(5);
		List<Future<Date>> results = new ArrayList<Future<Date>>();

		//testowe 20 konwersji
		for(int i = 0 ; i < 20 ; i++){
			results.add(exec.submit(task));
		}
		exec.shutdown();

		for(Future<Date> result : results){
			System.out.println(result.get());
		}
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("SDF: Default");
			//nawet jesli nie wystapi tutaj wyrzucenie wyjatku, to jest wielce prawdopodobne utworzenie daty z "smieciowego" inputu
			SimpleDateFormatDefault();
			System.out.println("=====");
		} catch (Exception e) {
			// tutaj lapiemy rozne wyjatki zwiazane z blednym imputem generowanym przez nakladajace sie watki
			e.printStackTrace();
			System.out.println("SimpleDateFormat is not thread-safe!\n=====");
		}
		try {
			System.out.println("SDF: Thread-Safe");
			SimpleDateFormatThreadSafe();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
