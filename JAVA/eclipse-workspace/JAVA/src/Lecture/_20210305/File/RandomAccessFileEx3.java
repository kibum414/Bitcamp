package Lecture._20210305.File;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx3 {

	public static void main(String[] args) {
		int sum = 0;
		
		try {
			// read : 읽기 모드
			// write : 쓰기 모드
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "r");

			// 번호는 더하는 게 아니므로 처음에는 4 (score 배열 타입이 int 형이기 때문)
			// 국어 점수 : 4
			// 영어 점수 : 8
			// 수학 점수 : 12
			int i = 4;
			
			while (true) {
				// 포인터의 위치를 변경하는 것 (단위 : 바이트)
				// i = 4 이므로 4바이트 만큼 감
				raf.seek(i);;
				
				sum += raf.readInt();
				
				// 4개 인덱스 건너뛰므로 4 * 4
				i += 16;
			}
		} catch (EOFException e) {
			System.out.println("sum : " + sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
