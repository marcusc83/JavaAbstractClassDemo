import javafx.application.Application;
import javafx.stage.Stage;


public class Final extends Application
{		
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		mainSceneHolder main = new mainSceneHolder();
		primaryStage.setScene(main.mainSceneceneSetter(primaryStage));
		primaryStage.show();
	}
}