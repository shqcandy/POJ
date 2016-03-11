package s100.s3;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String line = null;
		
		while(!(line = scan.nextLine().trim()).equals("0.00"))
		{
			BigDecimal bd = new BigDecimal(line);
			int i = 0;
			while(bd.compareTo(new BigDecimal(0.00)) > 0)
			{
				bd = bd.subtract(new BigDecimal(1.0 / (i + 2)));
				i++;
			}
			System.out.println(i + " card(s)");
		}
		scan.close();
	}
}
