import java.util.Scanner;

public class BarcodeChecksum2
{
	
	static int sum = 0;
	static int roundedSum = 0;
	public static void main(String[] args) 
	{
		System.out.println("Please enter 11 digits for the barcode and a \"m\" for the missing digit");
		Scanner input = new Scanner(System.in);
		String digits = input.nextLine();
		int[] barcode = new int[12];
		int mTracker = 11;
		for(int i = 0; i < barcode.length; i++)
		{
			if(digits.toCharArray()[i] == 'm')
			{
				mTracker = i;
				continue;
			}
			
			else if(i % 2 == 0)
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
		int mdigit = roundedSum - sum;
		if(mTracker % 2 == 0)
		{
			if(mdigit % 3 == 0)
			{
				mdigit = mdigit/3;
			}
			
			else if((mdigit+10) % 3 == 0)
			{
				mdigit = mdigit + 10;
				mdigit = mdigit/3;
			}
			
			else if((mdigit+20) % 3 == 0)
			{
				mdigit = mdigit + 20;
				mdigit = mdigit/3;
			}
			
		}
		
		System.out.println(mdigit);	
	}

}
