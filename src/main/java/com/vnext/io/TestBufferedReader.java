/**
 * 
 */
package com.vnext.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读取指定地址的文件信息
 * @author leo
 * @since 2018-02-06 17:58:51
 */
public class TestBufferedReader {

	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine()) != null) {
			sb.append(s).append("\n");
		}
		in.close();
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		String file = TestBufferedReader.class.getResource("/").getPath() + "/inPutFile.txt";
		System.out.print(read(file));
	}
}
