import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Run {

	public static void main(String[] args) {

		try (FileInputStream fin = new FileInputStream("C:\\Users\\ira.NOO2012\\Desktop\\czKYBP81d4Q.jpg");
				FileOutputStream fos = new FileOutputStream("D:\\i\\programming.jpg")) {
			byte[] buffer = new byte[fin.available()];
			// считываем буфер
			fin.read(buffer, 0, buffer.length);
			// записываем из буфера в файл
			fos.write(buffer, 0, buffer.length);
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}
}
