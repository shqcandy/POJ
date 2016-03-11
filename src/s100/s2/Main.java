package s100.s2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Main
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int number = Integer.parseInt(scan.nextLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < number; i++)
		{
			String line = scan.nextLine().trim();
			String re = "";

			for (int j = 0; j < line.length(); j++)
			{
				char ch = line.charAt(j);
				if(ch == '-')
					continue;
				if (Character.isDigit(ch))
				{
					re += ch;
					continue;
				}

				switch (ch)
				{
				case 'A':case 'B':case 'C':
					re += 2;break;
				case 'D':case 'E':case 'F':
					re += 3;break;
				case 'G':case 'H':case 'I':
					re += 4;break;
				case 'J':case 'K':case 'L':
					re += 5;break;
				case 'M':case 'N':case 'O':
					re += 6;break;
				case 'P':case 'R':case 'S':
					re += 7;break;
				case 'T':case 'U':case 'V':
					re += 8;break;
				case 'W':case 'X':case 'Y':
					re += 9;break;
				}
			}
			
			Integer times = map.get(re);
			map.put(re, times == null ? 1 : 1 + times);
		}
		scan.close();

		boolean b = true;
		for (String temp : new TreeSet<String>(map.keySet()))
		{
			int n = map.get(temp);
			if (n > 1)
			{
				b = false;
				System.out.println(temp.substring(0, 3) + "-"
						+ temp.substring(3, 7) + " " + n);
			}
		}

		if (b)
			System.out.println("No duplicates. ");
	}

}
