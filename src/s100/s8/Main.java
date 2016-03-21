package s100.s8;

import java.util.Scanner;

public class Main
{
	enum HAAB
	{
		pop, no, zip, zotz, tzec, xul, yoxkin, mol, chen, yax, 
		zac, ceh, mac, kankin, muan, pax, koyab, cumhu, uayet
	};
	private static int haab = 365;
	
	enum TZOLKIN
	{
		imix, ik, akbal, kan, chicchan, cimi, manik, lamat, 
		muluk, ok, chuen, eb, ben, ix, mem, cib, caban, eznab, 
		canac, ahau
	}
	private static int tzolkin = 13 * 20;

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int number = Integer.parseInt(scan.nextLine());
		
		TZOLKIN [] temp = TZOLKIN.values();
		
		System.out.println(number);
		for (int i = 0; i < number; i++)
		{
			String [] strings = scan.nextLine().trim().split("\\s+");
			int day = (int)Double.parseDouble(strings[0]);
			int month = HAAB.valueOf(strings[1].trim().toLowerCase()).ordinal();
			int year = Integer.parseInt(strings[2]);
			
			int days = haab * year + month * 20 + day;
			
			year = days / tzolkin;
			days = days % tzolkin;
			
			month = days % 20;
			day = days % 13 + 1;
			
			System.out.println(day + " " + temp[month] + " " + year);
		}
		scan.close();
	}
}
