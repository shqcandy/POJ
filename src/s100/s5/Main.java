package s100.s5;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		for (int i = 1; i <= number; i++)
		{
			double a = scan.nextDouble();
			double b = scan.nextDouble();
			
			double r = Math.sqrt(a * a + b * b);
			double temp = Math.PI * r * r / 100;
			
			int re = (int) temp;
			
			if(temp - re > 0)
				re ++;
			
			System.out.println("Property " + i + ": This property will begin eroding in year " + re + ".");
		}
		scan.close();
		
		System.out.println("END OF OUTPUT.");
	}

}
