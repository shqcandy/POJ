package s100.s7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int number = scan.nextInt();
		scan.nextLine();
		
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Inner> list = new ArrayList<Inner>(number);
		
		for(int i = 0 ; i < number ; i++)
		{
			String string = scan.nextLine().trim().substring(0, length);
			list.add(new Inner(string , getSorting(string)));
		}
		scan.close();
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}
	
	private static class Inner implements Comparable<Inner>
	{
		private String string;
		private Integer sorting;
		
		@Override
		public String toString()
		{
			return string;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((sorting == null) ? 0 : sorting.hashCode());
			result = prime * result
					+ ((string == null) ? 0 : string.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Inner other = (Inner) obj;
			if (sorting == null)
			{
				if (other.sorting != null)
					return false;
			}
			else if (!sorting.equals(other.sorting))
				return false;
			if (string == null)
			{
				if (other.string != null)
					return false;
			}
			else if (!string.equals(other.string))
				return false;
			return true;
		}

		public Inner(String string, Integer sorting)
		{
			super();
			this.string = string;
			this.sorting = sorting;
		}

		public int compareTo(Inner o)
		{
			return sorting.compareTo(o.sorting);
		}
	}
	
	private static int getSorting(String string)
	{
		int re = 0;
		for(int i = 0 ; i < string.length() ; i++)
		{
			for(int j = i + 1 ; j < string.length() ; j++)
			{
				if(i != j)
				{
					if(string.charAt(i) > string.charAt(j))
						re ++;
				}
			}
		}
		return re;
	}
}
