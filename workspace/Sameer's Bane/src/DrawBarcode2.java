import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DrawBarcode2 extends Application
{
	String str = "";
	Label response;
	
	static int sum = 0;
	static int roundedSum = 0;
	public static void main(String[] args) 
	{
		launch(args);	
	}
	
	public void init()
	{
		System.out.println("Inside the init() method.");
	}
	
	@Override
	public void start(Stage myStage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside the start() method.");
		myStage.setTitle("Sameer.");
		FlowPane rootNode = new FlowPane();
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 800, 500);
		myStage.setScene(myScene);
		Label label = new Label("Please Enter a Number");
		TextField text = new TextField("");
		
		response = new Label("Push the Button to see your barcode");
		Button btn = new Button("Done");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("Number Acknowledged");
				str = text.getText();
				System.out.println("Number Entered: " + str);
				int[] barcode = new int[12];
				int[][] code = new int[12][7];
				for(int i = 0; i < barcode.length; i++)
				{
					barcode[i] = str.toCharArray()[i]-48;
					if(i < 6)
					{
						switch(barcode[i])
						{
								case 0: code[i] = new int[]{0,0,0,1,1,0,1}; break;
								case 1: code[i] = new int[]{0,0,1,1,0,0,1}; break;
								case 2: code[i] = new int[]{0,0,1,0,0,1,1}; break;
								case 3: code[i] = new int[]{0,1,1,1,1,0,1}; break;
								case 4: code[i] = new int[]{0,1,0,0,0,1,1}; break;
								case 5: code[i] = new int[]{0,1,1,0,0,0,1}; break;
								case 6: code[i] = new int[]{0,1,0,1,1,1,1}; break;
								case 7: code[i] = new int[]{0,1,1,1,0,1,1}; break;
								case 8: code[i] = new int[]{0,1,1,0,1,1,1}; break;
								case 9: code[i] = new int[]{0,0,0,1,0,1,1}; break;
						}
					}
					
					else
					{
						switch(barcode[i])
						{
								case 0: code[i] = new int[]{1,1,1,0,0,1,0}; break;
								case 1: code[i] = new int[]{1,1,0,0,1,1,0}; break;
								case 2: code[i] = new int[]{1,1,0,1,1,0,0}; break;
								case 3: code[i] = new int[]{1,0,0,0,0,1,0}; break;
								case 4: code[i] = new int[]{1,0,1,1,1,0,0}; break;
								case 5: code[i] = new int[]{1,0,0,1,1,1,0}; break;
								case 6: code[i] = new int[]{1,0,1,0,0,0,0}; break;
								case 7: code[i] = new int[]{1,0,0,0,1,0,0}; break;
								case 8: code[i] = new int[]{1,0,0,1,0,0,0}; break;
								case 9: code[i] = new int[]{1,1,1,0,1,0,0}; break;
						}
					}
				}
				
				for(int i = 0; i < 2; i ++)
				{
				Rectangle guardBar = new Rectangle();
				guardBar.setX(30);
				guardBar.setY(100);
				guardBar.setWidth(3);;
				guardBar.setHeight(70);
				
				Rectangle space = new Rectangle();
				space.setX(30);
				space.setY(100);
				space.setWidth(3);;
				space.setHeight(70);
				space.setFill(Color.WHITE);
				rootNode.getChildren().addAll(guardBar, space);
				}
				
				for(int i = 0; i < code.length; i++)
				{
					for(int j = 0; j < code[0].length; j++)
					{
						Rectangle rect1 = new Rectangle();
						
						if(code[i][j] == 0)
						{
							rect1.setX(50);
							rect1.setY(900);
							rect1.setWidth(3);
							rect1.setHeight(50);
							rect1.setFill(Color.WHITE);
						
						}
						else
						{
							rect1.setX(50);
							rect1.setY(900);
							rect1.setWidth(3);
							rect1.setHeight(50);						
						}
						
						if(i == 6 && j == 0)
						{
							Rectangle firstSpace = new Rectangle();
							firstSpace.setX(30);
							firstSpace.setY(100);
							firstSpace.setWidth(3);
							firstSpace.setHeight(70);
							firstSpace.setFill(Color.WHITE);
							rootNode.getChildren().addAll(firstSpace);
							
							for(int k = 0; k < 2; k++)
							{
								Rectangle guardBar = new Rectangle();
								guardBar.setX(30);
								guardBar.setY(100);
								guardBar.setWidth(3);
								guardBar.setHeight(70);
								
								Rectangle space = new Rectangle();
								space.setX(30);
								space.setY(100);
								space.setWidth(3);
								space.setHeight(70);
								space.setFill(Color.WHITE);
								
								rootNode.getChildren().addAll(guardBar, space);
							}
						}
						
						rootNode.getChildren().add(rect1);
					}
				}
				
				for(int i = 0; i < 2; i ++)
				{
				Rectangle guardBar = new Rectangle();
				guardBar.setX(30);
				guardBar.setY(100);
				guardBar.setWidth(3);;
				guardBar.setHeight(70);
				
				Rectangle space = new Rectangle();
				space.setX(30);
				space.setY(100);
				space.setWidth(3);;
				space.setHeight(70);
				space.setFill(Color.WHITE);
				rootNode.getChildren().addAll(guardBar, space);
				}
		}
		});
		
		
		
		
		rootNode.getChildren().addAll(label, text, btn, response);
		myStage.show();
	}
	
	public void stop()
	{
		System.out.println("Inside the stop() method.");
	}
}