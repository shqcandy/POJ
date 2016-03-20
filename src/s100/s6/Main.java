package s100.s6;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int P = 23 , E = 28 , I = 33;

		int p = 0, e = 0, i = 0, d = 0;
		int number = 0;
		while (true)
		{
			number ++;
			p = scan.nextInt();
			e = scan.nextInt();
			i = scan.nextInt();
			d = scan.nextInt();
			
			if(p == -1 && e == -1 && i == -1 && d == -1)
				break;
			
			p %= P;	// 23
			e %= E; // 28 
			i %= I; // 33
			
			int j;
			for(j = 0 ; j < E ; j++)
			{
				int re = P * j + p - e;
				if(re % E == 0)
				{
					break;
				}
			}
			
			int sum1 = P * j + p;
			int SUM1 = P * E;
			int lnm = 0;
			for(lnm = 0 ; lnm < I ; lnm++)
			{
				int re = SUM1 * lnm + sum1 - i;
				if(re % I == 0)
				{
					break;
				}
			}
			
			int all = P * E * I;
			int sum = ((SUM1 * lnm + sum1 - d) + all ) % all;
			if(sum == 0)
				sum += all;
			
			System.out.println("Case " + number + ": the next triple peak occurs in " + sum + " days.");
		}
		scan.close();
	}
}
