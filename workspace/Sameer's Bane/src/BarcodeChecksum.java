import java.util.Scanner;

public class BarcodeChecksum 
{
	
	static int sum = 0;
	static int roundedSum = 0;
	public static void main(String[] args) 
	{
		
		System.out.println("Please enter the first eleven digits of the barcode");
		Scanner input = new Scanner(System.in);
		String digits = input.nextLine();
		int[] barcode = new int[11];
		for(int i = 0; i < barcode.length; i++)
		{
			if(i % 2 == 0)
			{
				barcode[i] = digits.toCharArray()[i]-48;
				barcode[i] = 3*barcode[i];
			}
			
			else
			{
				barcode[i] = digits.toCharArray()[i]-48;
			}
			sum += barcode[i];
		}
		
		roundedSum = (int) (Math.ceil(((float)sum)/10)*10);
		System.out.print("The last digit is " + (roundedSum-sum));
		
		
	}
}