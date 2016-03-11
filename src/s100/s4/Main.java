package s100.s4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		double re = 0;
		for (int i = 0; i < 12; i++)
		{
			double d = scan.nextDouble();
			re += d;
		}
		scan.close();
		re /= 12;
		System.out.println("$" + new DecimalFormat("#0.00").format(re));
	}

}
