package application;

import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ShowGraphics extends Application {

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");

		initRootLayout();

		//showPersonOwerview();
	}

	/**
	 * Инициализирует корневой макет.
	 */
	public void initRootLayout() {
		try {
			// Загружаем корневой макет из fxml файла.
			FXMLLoader loader = new FXMLLoader();
			// loader.setLocation(ShowGraphics.class.getResource("/view/RootLayout.fxml"));
			loader.setLocation(ShowGraphics.class.getResource("/view/PersonOwerview.fxml"));
			AnchorPane anchorPane = loader.load();
			
			/*final NumberAxis xAxis = new NumberAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        xAxis.setLabel("Number of Month");
	        //creating the chart
	        final LineChart<Number,Number> lineChart = 
	                new LineChart<Number,Number>(xAxis,yAxis);
	                
	        lineChart.setTitle("Stock Monitoring, 2010");
	        //defining a series
	        XYChart.Series series = new XYChart.Series();
	        series.setName("My portfolio");
	        //populating the series with data
	        series.getData().add(new XYChart.Data(1, 23));
	        series.getData().add(new XYChart.Data(2, 14));
	        series.getData().add(new XYChart.Data(3, 15));
	        series.getData().add(new XYChart.Data(4, 24));
	        series.getData().add(new XYChart.Data(5, 34));
	        series.getData().add(new XYChart.Data(6, 36));
	        series.getData().add(new XYChart.Data(7, 22));
	        series.getData().add(new XYChart.Data(8, 45));
	        series.getData().add(new XYChart.Data(9, 43));
	        series.getData().add(new XYChart.Data(10, 17));
	        series.getData().add(new XYChart.Data(11, 29));
	        series.getData().add(new XYChart.Data(12, 25));
	        
	        //Scene scene  = new Scene(lineChart,800,600);
	        lineChart.getData().add(series);*/

			// Отображаем сцену, содержащую корневой макет.
			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			System.out.println(e);
			//e.printStackTrace();
		}
	}

	/**
	 * Показывает в корневом макете сведения об адресатах.
	 */
	/*public void showPersonOwerview() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ShowGraphics.class.getResource("/view/PersonOwerview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
        	//System.out.println(e);
        	e.printStackTrace();
        }
    }*/

	/**
	 * Возвращает главную сцену.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
