import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Exercise1 {

	public static void main(String[] args) {
		

		ArrayList<String> arr = new ArrayList<>();
        Time.add(arr);
        Time.search(arr);
        Time.remove(arr);
		
       LinkedList <String> linl= new LinkedList<>();
       Time.add(linl);
       Time.search(linl);
       Time.remove(linl);
       
		HashSet<String> has= new HashSet<>();
		Time.add(has);
		Time.search(has);
		Time.remove(has);
		
		TreeSet<String> tree=new TreeSet<>();
		Time.add(tree);
		Time.search(tree);
		Time.remove(tree);


	}

}
