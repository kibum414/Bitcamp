package Lecture._20210305.File;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx1 {

	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");

			System.out.println("파일 포인터의 위치: " + raf.getFilePointer());
			
			// 4바이트 이동
			raf.writeInt(100);
			System.out.println("파일 포인터의 위치: " + raf.getFilePointer());
			
			// 8바이트 이동
			raf.writeLong(100L);
			System.out.println("파일 포인터의 위치: " + raf.getFilePointer());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
