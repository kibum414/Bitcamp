package Lecture._20210305.File;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStream {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream dis = null;
		
		try {
			// dat 는 바이트 파일이기 때문에 파일 용량 적게 차지
			fis = new FileInputStream("score.dat");
			dis = new DataInputStream(fis);
			
			while (true) {
				score = dis.readInt();
				System.out.println(score);
				
				sum += score;
			}
		} catch (EOFException e) {
			System.out.println("점수의 총합은 " + sum + "점 입니다.");
		} catch (IOException e) {
			
		}
	}

}
