package Lecture._20210305.File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {

	public static void main(String[] args) throws IOException {
		// 데이터가 어떤 형이든지 마음대로 쓸 수 있음
		// 다만 쓴 순서대로 읽어주어야 함
		// 쓴 순서 = 읽는 순서
		
		DataInputStream in = null;
		DataOutputStream out = null;
		
		try {
			int c;
			
			out = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream("data.bin")));
			
			out.writeDouble(3.14);
			// DataOutputStream은 기존의 바이트 스트림 객체의 랩퍼 클래스로만 생성될 수 있기 때문에
			// 먼저 버퍼된 파일
		
			out.writeInt(100);
			out.writeUTF("자신의 생각을 바꾸지 못하는 사람은 결코 현실을 바꿀 수 없다.");
			
			out.flush();
			in = new DataInputStream(new BufferedInputStream(
					new FileInputStream("data.bin")));
			
			System.out.println(in.readDouble());
	}

}
