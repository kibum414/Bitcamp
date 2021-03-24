package Lecture._20210305.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ByteStreamsLab {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("원본 파일 이름을 입력하세요.");
		
		String inputFileName = scan.next();
		
		System.out.println("복사 파일 이름을 입력하시오: ");
		String outputFileName = scan.next();
		
		// 파일을 open 했으면 반드시 close 시켜주어야 하는데 없음
		// 자바의 새로운 문법
		// try 안에 넣어주면 finally 안 써도 알아서 close 해줌
		
		// try 블록 안에서 스트림을 선언하고 초기화하면 이것들을 닫을 필요가 없다.
		// 다른 클래스에 대해서도 사용할 수 있으나 Closable
		try (InputStream inputStream = new FileInputStream(inputFileName);
				OutputStream outputStream = new FileOutputStream(outputFileName)) {
			
			int c;

			// 파일의 끝까지 읽기를 계속한다.
			while ((c = inputStream.read()) != -1) {
				outputStream.write(c);
			}
		}
		
		System.out.println(inputFileName + "을 " + outputFileName + "로 복사하였습니다.");
	}

}
