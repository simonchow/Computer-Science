import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class VigenereCipher extends Application
{
	String str = "";
	String str2 = "";
	Label label;
	Label label2;
	Label response;
	
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
		System.out.println("Inside the start() method.");
		myStage.setTitle("Vigenere Encoder/Decoder :)");
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL);
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 800, 500);
		myStage.setScene(myScene);
		ToggleGroup grp = new ToggleGroup();
		RadioButton encode = new RadioButton("Encode");
		encode.setToggleGroup(grp);
		encode.setSelected(true);
		RadioButton decode = new RadioButton("Decode");
		decode.setToggleGroup(grp);
		TextField text = new TextField("");
		label = new Label("Key:");
		Button btn = new Button("Done");
		TextField text2 = new TextField("");
		label2 = new Label("Input Text:");
		response = new Label();

		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				str = text.getText();
				str2 = text2.getText();
				char[][] vigenereTable = new char[26][26];
				for(int i = 0; i < vigenereTable.length; i++)
				{
					for(int j = 0; j < vigenereTable[0].length; j++)
					{
							int ascii = (i + j) % 26 + 65;
							vigenereTable[i][j] = (char) ascii;
					}
				}
				
				String key = "";
				
				while(key.length() < str2.length())
				{
					key += str;
				}
				
				while(key.length() > str2.length())
				{
					key = key.substring(0,key.length()-1);
				}
				
				str2 = str2.toUpperCase();
				key = key.toUpperCase();
				
				System.out.println(key + " " + str2);
				
				if(encode.isSelected())
				{
					String encrypted = "";
					
					for(int i = 0; i < str2.length(); i++)
					{
						encrypted += vigenereTable[str2.charAt(i) - 65][key.charAt(i) - 65];
					}
					
					response.setText("Encoded Text: " + encrypted);
				}
				else
				{
					String decrypted = "";
					
					for(int i = 0; i < str2.length(); i++)
					{
						for(int j = 0; j < vigenereTable.length; j++)
						{
							 if(vigenereTable[j][key.charAt(i) - 65] == str2.charAt(i))
							 {
								 decrypted += (char)(j+65);
							 }
						}
					}
					
					response.setText("Decoded Text: " + decrypted);
				}
			}
		});
		
		rootNode.getChildren().addAll(encode, decode, label, text, label2, text2, btn, response);
		myStage.show();
	}
	
	public void stop()
	{
		System.out.println("Inside the stop() method."); 
	}
}
