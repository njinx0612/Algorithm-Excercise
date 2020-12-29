package time;

public class PrintExecTime {
	
	public static long printStartTime() {
		return System.currentTimeMillis();
	}

	public static long printFinishTime() {
		return System.currentTimeMillis();
	}
	

//	public static void main(String[] args) {
//		long startTime = printStartTime();
//		System.out.println(startTime);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		long finishTime = printFinishTime();
//		System.out.println(finishTime);
//		
//		System.out.println((finishTime - startTime)/1000);
//		
//	}

}
