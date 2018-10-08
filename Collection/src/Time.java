
import java.util.Collection;

public class Time {

	public static <E> void add(Collection<E> col) {
		long start = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			col.add((E) Integer.toString(i));
		}
		long finish = System.currentTimeMillis() - start;
		System.out.println("Добавление 100000 элементов в коллекцию " + col.getClass() + " " + finish + " в млс");
		System.out.println("----------------------------------------------------");
		return;
	}

	public static <E> void remove(Collection<E> col) {
		long start = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			col.remove((E) Integer.toString(i));
		}
		long finish = System.currentTimeMillis() - start;
		System.out.println("Удаление 100000 элементов из коллекции  " + col.getClass() + " " + finish + " в млc");
		System.out.println("-----------------------------------------------------");
		return;

	}

	public static <E> void search(Collection<E> col) {
		long finish = 0;
		long start = System.currentTimeMillis();

		if (col.contains((E) "5000")) {
			finish = System.currentTimeMillis() - start;
		} else {
			System.out.println("Такого значения в коллекцтт нет");
		}

		System.out
				.println("Поиск элемента 5000-ого элемента  в коллекции  " + col.getClass() + " " + finish + " в млc");
		System.out.println("-------------------------------------------------------");
		return;
	}
}