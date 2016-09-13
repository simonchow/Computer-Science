import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;

public class SamDog extends Application {

	Label response;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		System.out.println("Hello world!");
		launch(args);
		
	}
	
	public void init()
	{
		System.out.println("Inside the init() method.");
	}
	
	public void start(Stage myStage)
	{
		//do button stuff 
		
		System.out.println("Inside the start() method.");
		myStage.setTitle("Sameer.");
		FlowPane rootNode = new FlowPane();
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 500, 380);
		myStage.setScene(myScene);
		response = new Label("Push a Button")
		Button btnUp = new Button("Up");
		Button btnUp = new Button("Down");
		
		btnUp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("You pressed Sam.");
			}
		});
		
		btnDown.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("You pressed eer.");
			}
		});
		
		rootNode.getChildren().addAll(btnUp, btnDown, response);
		
		myStage.show();
	}
	
	public void stop()
	{
		System.out.println("Inside the stop() method.");
	}
	
	

}
