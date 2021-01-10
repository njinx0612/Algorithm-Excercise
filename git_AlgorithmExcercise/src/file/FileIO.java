package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileIO {

	public static void main(String[] args) {

		FileWriter fwObj = logFileCreate(true, false);
		
		System.out.println("99999");
		System.out.println("5165498");
		System.out.println("5649832494");
//		try {
//			fwObj.write("hi\n");
//			fwObj.flush();
//			fwObj.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
	public static FileWriter logFileCreate(boolean fileAppend, boolean history) {
		Date today = new Date();
		String nowDate = "";

		SimpleDateFormat dtFormat = null;
		if( history) {
			dtFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SS"); //로그 이력이 필요할 경우 사용
		}else {
			dtFormat = new SimpleDateFormat("yyyy-MM-dd");
		}
		nowDate = dtFormat.format(today);
		
		File fd = new File(nowDate + ".log");
		
		try {
			PrintStream printStream = null;
			printStream = new PrintStream(new FileOutputStream(fd, fileAppend));
			System.setOut(printStream);
			System.setErr(printStream);
			return new FileWriter(fd, fileAppend); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
//		return null;
		
	}
	
//	public static void logFileWrite(FileWriter fwObj) {
//		Date today = new Date();
//		String nowDate = "";
//		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
//		nowDate = dtFormat.format(today);
//		
//		fwObj.write
//	}

}
