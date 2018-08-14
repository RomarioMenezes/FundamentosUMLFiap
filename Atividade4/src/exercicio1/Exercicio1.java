package exercicio1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Exercicio1 {

	public static void main(String[] args) throws InterruptedException {
	     Thread t1 = new ThreadA();
	     Thread t2 = new ThreadB();
	     
	     t1.start();
	     t2.start();
	     
	     while(true) {
	    	 System.out.println("T1: "+t1.getState());
	    	 System.out.println("T2: "+t2.getState());
	    	 Thread.sleep(5000);
	     }
	}
	
}

class ThreadA extends Thread {
	
	List<String> list = new ArrayList<>();
 
	@Override
	public void run() {
		
		list.add("Romário Menezes");
		list.add("asdasdasdas asdasdasdasd");
		list.add("osadoasodmas osamdoasmdoasd");
		list.add("oasdmoasmdomasodmasdm asdasd askdasdkjaskdkjasd");
		list.add("ASDsadaslmdlmasldmlasdasldmas asldmlasdmlasd");
		list.add("Sasdasd asdasdsad asdasdasd");
		list.add("ewqewqe  sdasdasdsadasd");
		list.add("MMkkkkkk kkkkkk kkkkkk kkkkkkkkkkkasdasd asdas");
		
		list.forEach(l -> {
			try {
				System.out.println(l);
				sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}


class ThreadB extends Thread {
 
	@Override
	public void run() {
		
		LocalDateTime data = null;
		while(true) {
			data = LocalDateTime.now();
			System.out.println(data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


