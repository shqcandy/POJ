package edu.ccnu.nlp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TFIDF
{
	// tf格式：( 文件路径名 : ( 单词 : 词频 ) )
	final private Map<String, HashMap<String, Integer>> tf = new HashMap<String, HashMap<String, Integer>>();
	final private Map<String, Integer> df = new HashMap<String, Integer>();
	// idf格式：( 单词 : IDF )
	final private Map<String, Double> idf = new HashMap<String, Double>();

	final private String corpusPath;
	final private String charSet;

	/**
	 * 获取计算所得的TF值
	 * 
	 * @return
	 */
	public Map<String, HashMap<String, Integer>> getTf()
	{
		return tf;
	}

	/**
	 * 获取计算所得的IDF值
	 * 
	 * @return
	 */
	public Map<String, Double> getIdf()
	{
		return idf;
	}

	/**
	 * 初始化类
	 * 
	 * @param corpusPath
	 *            待计算TF-IDF的文件夹
	 */
	public TFIDF(String corpusPath, String charSet)
	{
		this.corpusPath = corpusPath;
		this.charSet = charSet;
	}

	/**
	 * 计算TF-IDF值
	 * 
	 * @throws IOException
	 */
	public void calculate() throws IOException
	{
		int number = 0;
		number = forAllFiles(number, new File(corpusPath));

		for (Entry<String, Integer> entry : df.entrySet())
		{
			idf.put(entry.getKey(), Math.log(1.0 * number / entry.getValue()));
		}

	}

	private int forAllFiles(int number, File path)
			throws UnsupportedEncodingException, FileNotFoundException,
			IOException
	{
		if (path.isFile())
		{
			number++;

			String text = readFile(path, charSet);
			HashMap<String, Integer> temp = new HashMap<String, Integer>();
			for (String string : text.split("\\s+"))
			{
				if (temp.containsKey(string))
				{
					temp.put(string, 1 + temp.get(string));
				}
				else
				{
					temp.put(string, 1);
				}
			}

			tf.put(path.getAbsolutePath(), temp);

			for (String string : temp.keySet())
			{
				if (df.containsKey(string))
				{
					df.put(string, 1 + df.get(string));
				}
				else
				{
					df.put(string, 1);
				}
			}
		}
		else if (path.isDirectory())
		{
			for (File file : path.listFiles())
			{
				number = forAllFiles(number, file);
			}
		}

		return number;
	}

	/**
	 * 根据路径以及字符集设置，以字符串的格式获取文件的内容
	 * 
	 * @param file
	 *            文件路径，以文件的形式来表示
	 * @param charset
	 *            文件的字符集设置
	 * @return 返回文件的字符序列
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String readFile(File file, String charset)
			throws UnsupportedEncodingException, FileNotFoundException,
			IOException
	{
		StringBuilder re = new StringBuilder();

		String line = "";
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(file), charset));
		while ((line = br.readLine()) != null)
		{
			re.append(line + "\n");
		}
		br.close();
		return re.toString();
	}

}
