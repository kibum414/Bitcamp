package Lecture._20210305.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
The language of truth is simple.
Easier said than done.
First think and speak.
Translators, traitors.
No smoke without fire.
 */
public class CopyFileStream {

	public static void main(String[] args) throws IOException {
		
		// input.txt 파일에 연결된 파일 입력 스트림을 생성한다.
		FileInputStream in = null;
		FileOutputStream out = null;

		// 파일을 읽을 때는 반드시 try ~ finally 사용
		// 파일을 사용 후에는 반드시 close 시켜주어야 함
		
		// output.txt 파일에 연결된 파일 출력 스트림을 생성한다.
		try {
			// Stream : 바이트 단위로 읽음. 바이트 스트림
			// 이미지 읽을 때 사용
			in = new FileInputStream("input.txt");
			out = new FileOutputStream("output.txt");
			
			int c;

			// 하나의 바이트를 읽을 때는 read()를 사용하고
			// 하나의 바이트를 쓸 때는 write()를 사용한다.
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null)
				in.close();
			
			if (out != null)
				out.close();
		}
		
	}

}
