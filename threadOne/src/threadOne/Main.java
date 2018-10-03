package threadOne;

public class Main {

	public static void main(String[] args) {
		
		MyThread thread = new MyThread();
		System.out.println(thread.getName());
		System.out.println(thread);
		thread.start();
		/*MyRunnable runnable = new MyRunnable();
		Thread a = new Thread(runnable);
		Thread b = new Thread(runnable);
		Thread c = new Thread(runnable);
		Thread d = new Thread(runnable);
		a.setName("A");
		b.setName("B");
		c.setName("C");
		d.setName("D");
		
		a.start();
		b.start();
		c.start();
		d.start();*/
		

	}

}
