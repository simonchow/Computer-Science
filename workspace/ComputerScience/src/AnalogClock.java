import javafx.application.*;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.animation.*;

import static java.util.Calendar.*;
import java.util.Calendar;

public class AnalogClock extends Application{
	public static void main (String [] args)
	{
		launch(args);
	}

	@Override public void start(Stage primaryStage) throws Exception
	{
		int radius = 300;
		int xcenter = 360;
		int ycenter = 360;
		int tickLength = 30;
		int shortTick = 10;
		
		Color trans = Color.TRANSPARENT;
		Color black = Color.BLACK;
		
		Circle clock = new Circle(xcenter, ycenter, radius);//Create circle
		clock.setFill(trans);
		clock.setStroke(black);
		
		Line marks[] = new Line[12];//Create marks on clock edge
		for (int i = 0; i < marks.length; i++)
		{
			marks[i] = new Line();
			marks[i].setStartX(Math.cos(Math.PI/6 * i) * radius + xcenter);
			marks[i].setStartY(Math.sin(Math.PI/6 * i) * radius + ycenter);
			marks[i].setEndX(Math.cos(Math.PI/6 * i) * (radius -tickLength) + xcenter);
			marks[i].setEndY(Math.sin(Math.PI/6 * i) * (radius - tickLength) + xcenter);
			marks[i].setStrokeWidth(3);
		}
		
		Line minimarks[] = new Line[60];//Create tiny marks
		for (int j = 0; j < minimarks.length; j++)
		{
			minimarks[j] = new Line();
			minimarks[j].setStartX(Math.cos(Math.PI/30 * j) * radius + xcenter);
			minimarks[j].setStartY(Math.sin(Math.PI/30 * j) * radius + ycenter);
			minimarks[j].setEndX(Math.cos(Math.PI/30 * j) * (radius - shortTick) + xcenter);
			minimarks[j].setEndY(Math.sin(Math.PI/30 * j) * (radius - shortTick) + xcenter);
		}
		
		
		
		
		Line hourHand = new Line();
		Line minHand = new Line();
		Line secHand = new Line();
		
		AnimationTimer timer = new AnimationTimer()
		{
			@Override
			public void handle(long args)
			{
				Calendar calendar = Calendar.getInstance();
				
				int sec = calendar.get(SECOND);
				int min = calendar.get(MINUTE);
				int hour = calendar.get(HOUR);
				int secLength = 240;
				int minLength = 200;
				int hourLength = 100;
				Color green = Color.GREEN;
				Color blue = Color.BLUE;
				Color red = Color.RED;
				
				System.out.println(sec);
				
				secHand.setStartX(360);
				secHand.setStartY(360);
				secHand.setEndX(Math.cos((Math.PI/2)-(sec)*(Math.PI/30)) * (-1) * (secLength) + xcenter);
				secHand.setEndY(Math.sin((Math.PI/2)-(sec)*(Math.PI/30)) * (-1) * (secLength) + ycenter);
				secHand.setStroke(blue);
				secHand.setStrokeWidth(2);
				
				minHand.setStartX(360);
				minHand.setStartY(360);
				minHand.setEndX(Math.cos((Math.PI/2)*(-1)-(min)*(Math.PI/30)) * (minLength) + xcenter);
				minHand.setEndY(Math.sin((Math.PI/2)*(-1)-(min)*(Math.PI/30)) * (minLength) + ycenter);
				minHand.setStroke(green);
				minHand.setStrokeWidth(4.5);

				hourHand.setStartX(360);
				hourHand.setStartY(360);
				hourHand.setEndX(Math.cos((Math.PI/2)*(-1)-(hour)*(Math.PI/30)) * (hourLength) + xcenter);
				hourHand.setEndY(Math.sin((Math.PI/2)*(-1)-(hour)*(Math.PI/30)) * (hourLength) + ycenter);
				hourHand.setStroke(red);
				hourHand.setStrokeWidth(7);
				
			}
		};
		timer.start();
		
		Group root = new Group();
		root.getChildren().addAll(clock, hourHand, minHand, secHand);
		
		for (int a = 0; a < marks.length; a++)
		{
			root.getChildren().addAll(marks[a]);
		}
		for (int b = 0; b < minimarks.length; b++)
		{
			root.getChildren().addAll(minimarks[b]);
		}
		Scene scene = new Scene(root, 720, 720);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Clock");
		primaryStage.show();
	}
}

       
