package controller;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Drawing implements Initializable {
	@FXML
	private Button drawButton;
	@FXML
	private Button graphicButton;
	@FXML
	private TextField numberText;
	@FXML 
	private LineChart<Number, Number> graphicLine;
	@FXML
	private CategoryAxis xAxis;
	@FXML
	private NumberAxis yAxis;
	@FXML
	private ScrollBar xScroll;
	@FXML
	private ScrollBar yScroll;

	XYChart.Series<Number, Number> series = new Series<>();
	XYChart.Series<Number, Number> series1 = new Series<>();
	int i = 0;

	public Drawing() {
		series.setName("Chanel 1");
		xAxis = new CategoryAxis();
		//series.getData().add(new XYChart.Data<>(Integer.toString(i),0));
		//series1.getData().add(new XYChart.Data<>(Integer.toString(i),0+5));

	}

	public void drawCliked(ActionEvent event) {
		System.out.println("Button Clicked!");

		Date now= new Date();

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");


		// Model Data
		String dateTimeString = df.format(now);

		// Show in VIEW
		numberText.setText(dateTimeString);

	}

	public void yScrolling() {

	}

	public void xScrilling() {

	}

	public void graphLine(ActionEvent event) {
		//graphicLine.setTitle("null");
		try {
			graphicLine.getData().clear();
			String a = numberText.getText();
			int b = Integer.parseInt(a);
			series.getData().add(new XYChart.Data<>(i,b));
			series1.getData().add(new XYChart.Data<>(i,b+5));
			series.setName("Chanel 1");
			series1.setName("Chanel 2");
			graphicLine.getData().clear();
			graphicLine.getData().add(series);
			graphicLine.getData().add(series1);
			i++;
		} catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);

			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("Enter some number or enter NUMBER!");

			alert.showAndWait();;
		}

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	/*@FXML
    public void initialize(){
        drawButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                drawButton.setText("Thanks!");
            }
        });
    }*/

}
