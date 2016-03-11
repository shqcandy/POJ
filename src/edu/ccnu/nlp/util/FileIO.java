package edu.ccnu.nlp.util;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 文件操作类，常用的文件操作过程。
 */

public class FileIO
{
	/**
	 * @param path 待解析的Properties文件路径
	 * @return 待解析的Properties文件对象
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public static Properties getProperties(String path) throws FileNotFoundException, IOException
	{
		Properties re = new Properties();
		re.load(new FileInputStream(path));
		return re;
	}
	
	/**
	 * 根据路径以及字符集设置，以字符串的格式获取文件的内容
	 * @param file 文件路径，以文件的形式来表示
	 * @param charset 文件的字符集设置
	 * @return 返回文件的字符序列
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 * @throws IOException
	 */
	public static String readFile(File file, String charset) throws UnsupportedEncodingException, FileNotFoundException, IOException
	{
		StringBuilder re = new StringBuilder();

		String line = "";
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(file),
						charset)))
		{
			while ((line = br.readLine()) != null)
			{
				re.append(line + "\n");
			}
		}
		return re.toString();
	}

	/**
	 * 将文本字符串写入到文件中去
	 * @param text 文本内容
	 * @param file 文件路径
	 * @param charset 文件字符集设置
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 * @throws IOException
	 */
	public static void writeFile(String text, File file, String charset) throws UnsupportedEncodingException, FileNotFoundException, IOException
	{
		try (BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(
						file), charset)))
		{
			bw.write(text);
		}
	}

	/**
	 * 根据文件路径以及特定的类型，从文件中获取对象（仅获取第一个）
	 * @param file 文件路径
	 * @return 返回从文件中获取到的对象
	 * @throws FileNotFoundException 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T readObject(File file) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		T re = null;
		try (ObjectInputStream ois = new ObjectInputStream(
				new GZIPInputStream(new BufferedInputStream(
						new FileInputStream(file)))))
		{
			re = (T) ois.readObject();
		}
		return re;
	}

	/**
	 * 将object对象写入到文件file中去（仅限一个对象）
	 * @param file 待写入对象文件的路径
	 * @param object 待写入的对象
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public static <T> void writeObject(File file, T object) throws FileNotFoundException, IOException
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new GZIPOutputStream(new BufferedOutputStream(
						new FileOutputStream(file)))))
		{
			oos.writeObject(object);
		}
	}
}
