package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainRunner extends Application
{
	public static Stage window;
	public static Scene scene;
	private Group root;
	
	//Launches the program. Launch calls the start method.
	public static void main(String[] args)
	{
		launch(args);
	}

	//the start of the program
	@Override
	public void start(Stage mainStage) throws Exception
	{
		window = mainStage;
		window.setTitle("QuickCards");
		
		root = new Group();
		scene = new Scene(root, 800, 600);
		
		
		window.setScene(scene);
		window.show();
	}
}
