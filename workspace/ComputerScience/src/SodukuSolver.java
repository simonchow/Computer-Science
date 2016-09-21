import javafx.application.*;


import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.animation.*;

import static java.util.Calendar.*;
import java.util.Calendar;

public class SodukuSolver extends Application{
	public static void main (String [] args)
	{
		launch(args);
	}

	@Override public void start(Stage primaryStage) throws Exception
	{
		int SceneW = 1000;
		int SceneH = 1000;
		int frameW = (int) (0.8*SceneW);
		int frameH = (int) (0.8*SceneH);
	
		Rectangle frame = new Rectangle();
		frame.setX(100);
		frame.setY(100);
		frame.setWidth(frameW);
		frame.setHeight(frameH);
		frame.setFill(Color.WHITE);
		frame.setStroke(Color.BLACK);
		frame.setStrokeWidth(5);
		
		Line horLines[] = new Line[8]; 
		for(int i = 0; i < horLines.length; i++)
		{
			horLines[i] = new Line();
			horLines[i].setStartX((SceneW-frameW)/2 + (i + 1) * (frameW/9));
			horLines[i].setStartY((SceneH-frameH)/2);
			horLines[i].setEndX((SceneW-frameW)/2 + (i + 1) * (frameW/9));
			horLines[i].setEndY(SceneH - (SceneH-frameH)/2);
			
			if((i+1) % 3 == 0)
			{
				horLines[i].setStrokeWidth(5);
			}
			else
			{
				horLines[i].setStrokeWidth(1);
			}
		}
		
		Line vertLines[] = new Line[8];  //Creates the larger tick marks of the clock)
		for(int i = 0; i < horLines.length; i++)
		{
			vertLines[i] = new Line();
			vertLines[i].setStartX(((SceneW-frameW)/2));
			vertLines[i].setStartY((SceneH-frameH)/2 + (i + 1) * (frameH/9));
			vertLines[i].setEndX(SceneW - (SceneW - frameW)/2);
			vertLines[i].setEndY((SceneH-frameH)/2 + (i + 1) * (frameH/9));
			vertLines[i].setStrokeWidth(1);
			
			if((i+1) % 3 == 0)
			{
				vertLines[i].setStrokeWidth(5);
			}
			else
			{
				vertLines[i].setStrokeWidth(1);
			}
		}
		
		
		
		
		TextField NumInputs[] = new TextField[81]; 
		
		for(int i = 0; i < 81; i++)
		{
			NumInputs[i] = new TextField();
		}
		
		
		
		Group root = new Group();
		root.getChildren().addAll(frame);
		for (int a = 0; a < horLines.length; a++)
		{
			root.getChildren().addAll(horLines[a]);
		}
		for (int a = 0; a < vertLines.length; a++)
		{
			root.getChildren().addAll(vertLines[a]);
		}
		for (int a = 0; a < NumInputs.length; a++)
		{
			root.getChildren().addAll(NumInputs[a]);
		}
		
		Scene scene = new Scene(root, SceneW, SceneH);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Sudoku");
		primaryStage.show();
	}
}

       
