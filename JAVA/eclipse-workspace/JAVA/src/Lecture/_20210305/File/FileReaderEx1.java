package Lecture._20210305.File;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {

	public static void main(String[] args) {
		try {
			String fileName = "input.txt";
			
			// 바이트 단위 : 한글이 깨져서 나옴. UTF8로 명시해주면 됨.
			FileInputStream fis = new FileInputStream(fileName);
			// 문자 단위 : 한글이 깨지지 않고 나옴
			FileReader fr = new FileReader(fileName);
			
			int data = 0;
			
			// -1 : 파일의 끝
			// 끝이 나올 때까지 읽음
			while ((data = fis.read()) != -1) {
				System.out.print((char)data);
			}
			System.out.println();
			
			fis.close();
			
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println();
			
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // main

}
