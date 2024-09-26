package projectFiles;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;  



public class App extends Application{  

    public static void main(String[] args) {  
        launch(args);
    }  

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Sort");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("App.fxml"))));
        primaryStage.show();
    }
}  
