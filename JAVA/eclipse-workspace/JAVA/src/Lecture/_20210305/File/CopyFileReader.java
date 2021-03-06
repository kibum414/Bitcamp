package Lecture._20210305.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileReader {

	public static void main(String[] args) throws IOException {
		// input.txt 파일에 연결된 파일 입력 스트림을 생성한다.
		FileReader inputStream = null;
		
		// output.txt 파일에 연결된 파일 출력 스트림을 생성한다.
		FileWriter outputStream = null;
		
		try {

			// Reader : 문자 단위로 읽음
			inputStream = new FileReader("input.txt");
			outputStream = new FileWriter("output.txt");
			
			int c;

			// 하나의 문자를 읽을 때는 read()를 사용하고
			// 하나의 문자를 쓸 때는 write()를 사용한다.
			while ((c = inputStream.read()) != -1) {
				outputStream.write(c);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}
