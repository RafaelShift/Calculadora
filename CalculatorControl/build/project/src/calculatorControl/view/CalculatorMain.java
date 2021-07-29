package calculatorControl.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CalculatorMain extends Application{
	    
	    @Override
	    public void start(Stage stage) throws Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("CalculatorControl.fxml"));
	        Scene scene = new Scene(root);   
	        stage.getIcons().add(new Image("file:///C:/Users/Toshiba/eclipse-workspace/CalculatorControl/resources/images/calculadora.png"));
	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.show();
	    }
	    
	    public static void main(String[] args) {
	        launch(args);
	    }
}