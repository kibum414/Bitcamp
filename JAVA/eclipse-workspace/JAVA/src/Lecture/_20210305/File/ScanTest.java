package Lecture._20210305.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanTest {

	public static void main(String[] args) throws IOException {
		
		Scanner s = null;
		
		try {
			s = new Scanner(new BufferedReader(new FileReader("input.txt")));
			
			// s.useDelimeter(",");
			// 공백 단위로 끊어서 단어 출력
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}

}
