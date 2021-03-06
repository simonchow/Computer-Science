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
		
		Circle clock = new Circle(xcenter, ycenter, radius); //Creates the frame of the clock 
		clock.setFill(Color.WHITE);
		clock.setStroke(black);
		
		
		Line marks[] = new Line[12];  //Creates the larger tick marks of the clock)
		for (int i = 0; i < marks.length; i++)
		{
			marks[i] = new Line();
			marks[i].setStartX(Math.cos(Math.PI/6 * i) * radius + xcenter);
			marks[i].setStartY(Math.sin(Math.PI/6 * i) * radius + ycenter);
			marks[i].setEndX(Math.cos(Math.PI/6 * i) * (radius -tickLength) + xcenter);
			marks[i].setEndY(Math.sin(Math.PI/6 * i) * (radius - tickLength) + xcenter);
			marks[i].setStrokeWidth(3);
		}
		
		Line minimarks[] = new Line[60]; //Create the tiny tick marks of the clock
		for (int j = 0; j < minimarks.length; j++)
		{
			minimarks[j] = new Line();
			minimarks[j].setStartX(Math.cos(Math.PI/30 * j) * radius + xcenter);
			minimarks[j].setStartY(Math.sin(Math.PI/30 * j) * radius + ycenter);
			minimarks[j].setEndX(Math.cos(Math.PI/30 * j) * (radius - shortTick) + xcenter);
			minimarks[j].setEndY(Math.sin(Math.PI/30 * j) * (radius - shortTick) + xcenter);
		}
		
		
		
		//Creates the three hands for the clock
		Line hourHand = new Line();
		Line minHand = new Line();
		Line secHand = new Line();
		
		//The Animation Component for the Clock
		AnimationTimer timer = new AnimationTimer()
		{
			@Override
			public void handle(long args)
			{
				Calendar calendar = Calendar.getInstance();
				
				//uses the calendar to get the updated time about 60 times a second 
				double sec = calendar.get(SECOND);
				double min = calendar.get(MINUTE) + sec/60;
				double hour = calendar.get(HOUR)+ min/60;
				
				//gives lengths to the three hands with the second hang being the longest and the hour being the shortest
				int secLength = 240;
				int minLength = 200;
				int hourLength = 100;
				
				Color green = Color.GREEN;
				Color blue = Color.BLUE;
				Color red = Color.RED;
				
				System.out.println(sec + " and " + hour);
				
				//sets the position for the second hand
				secHand.setStartX(360);
				secHand.setStartY(360);
				secHand.setEndX(-Math.sin(-Math.PI * sec/30) * secLength + xcenter); //these math formulas enable the second hand to adjust 
				secHand.setEndY(-Math.cos(-Math.PI * sec/30) * secLength + ycenter); //itself correctly after every update from the calendar
				secHand.setStroke(blue);
				secHand.setStrokeWidth(2);
				
				//sets the position for the minute hand
				minHand.setStartX(360);
				minHand.setStartY(360);
				minHand.setEndX(-Math.sin(-Math.PI * min/30) * minLength + xcenter);
				minHand.setEndY(-Math.cos(-Math.PI * min/30) * minLength + ycenter);
				minHand.setStroke(green);
				minHand.setStrokeWidth(4.5);

				//sets the position for the hour hand
				hourHand.setStartX(360);
				hourHand.setStartY(360);
				hourHand.setEndX(-Math.sin(-Math.PI * (hour*5)/30) * hourLength + xcenter); //the hour object is multiplied by five as there are 12 numbers for the 
				hourHand.setEndY(-Math.cos(-Math.PI * (hour*5)/30) * hourLength + ycenter); //hours of a day, rather than the 60 seconds in a minute and 60 minutes in an hour
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

/* int[][] ks = new int[9][9];
Button[][] original = new Button[9][9];
for(int i = 0; i <  NumInputs.length; i++)
{
	original[i] = Arrays.copyOf(NumInputs[i], NumInputs[i].length);
}

for(int i = 0; i < 9; i++)
{
	for(int j = 0; j < 9; j++)
	{
		if(buttonToInt(original[i][j]) != 0)
		{
			continue;
		}
		boolean tracker = true;
		for(int k = ks[i][j] + 1; k < 10; k ++)
		{
			if(check(i,j,k))
			{
				NumInputs[i][j].setText(Integer.toString(k));
				ks[i][j] = k;
				System.out.println(i + " " + j + " " + k);
				tracker = false;
				break;
			}
		}
		
		if(tracker)
		{
			NumInputs[i][j].setText("");
			ks[i][j] = 0;
			j -= 2;
			
			if(j < -1)
			{
				System.out.println("ERROR");
				break;
			}
		}
	}
}
}
});*/

       
