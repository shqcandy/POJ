package s100.s1;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext())
		{
			String a = cin.next();
			int t = cin.nextInt();
			BigDecimal ans = new BigDecimal(a);
			ans = ans.pow(t);
			String result = ans.stripTrailingZeros().toPlainString();
			if (result.charAt(0) == '0')
				result = result.substring(1);
			System.out.println(result);
		}
		cin.close();
	}
}
