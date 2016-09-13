import java.util.Scanner;

public class BarcodeMissingDigit
{
	public static void main (String [] args)
	{
		int currentnum = 0;
		int sum = 0;
		int blankspace = 0;
		Scanner in = new Scanner(System.in);
		int[] barcode = new int[12];
		
		System.out.println("Enter 12 digits. Use -1 for the missing digit.");
		for (int i = 0; i < barcode.length; i++)
		{
			currentnum = in.nextInt();
			if (currentnum == -1)
			{
				blankspace = i;
			}
			else
			{
				barcode[i] = currentnum;
				if(i % 2 == 0)
				{
					sum = sum + (3 * currentnum);
				}
				else
				{
					sum = sum + currentnum;
				}
			}
		}
		
		int roundedsum = (int) (Math.ceil(sum / 10) * 10);
		int missingnum = sum - roundedsum;
		if(blankspace % 2 == 0)
		{
			missingnum = missingnum / 3;
		}
		
		System.out.println(missingnum);
	}
}
