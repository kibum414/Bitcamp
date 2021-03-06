package Lecture._20210305.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// test.zip 이라는 압축 파일 생성
public class ZipTest2 {

	public static void main(String[] args) throws IOException {
		String outputFile = "test.zip";
		int level = 9;
		
		FileOutputStream fout = new FileOutputStream(outputFile);
		ZipOutputStream zout = new ZipOutputStream(fout);
		
		zout.setLevel(level);
		
		ZipEntry entry = new ZipEntry("input.txt");
		FileInputStream fin = new FileInputStream("input.txt");
		
		zout.putNextEntry(entry);
		
		// zout에 압축한 것을 씀
		for (int c = fin.read(); c != -1; c = fin.read()) {
			zout.write(c);
		}
		
		fin.close();
		zout.close();
	}

}
