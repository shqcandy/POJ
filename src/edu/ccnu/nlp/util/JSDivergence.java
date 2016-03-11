package edu.ccnu.nlp.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class JSDivergence
{
	// 两篇文档越相似，其js距离越小
	public static double js(Map<String, Double> text1 , Map<String, Double> text2)
	{
		double re = 0.0;
		Map<String, Double> sum = new HashMap<String, Double>();
		for (Entry<String, Double> entry : text1.entrySet())
		{
			sum.put(entry.getKey(), entry.getValue() / 2);
		}
		for (Entry<String, Double> entry : text2.entrySet())
		{
			Double v = sum.get(entry.getKey());
			double value = ((v != null) ? v: 0);
			sum.put(entry.getKey(), entry.getValue() / 2 + value);
		}
		
		re += 0.5 * (kl(text1 , sum) + kl(text2 , sum));
		
		return re;
	}
	
	public static double kl(Map<String, Double> text1 , Map<String, Double> text2)
	{
		double re = 0.0;
		
		for (Entry<String, Double> entry : text1.entrySet())
		{
			re += entry.getValue() * Math.log(entry.getValue() / text2.get(entry.getKey()));
		}
		
		return re;
	}
}
