
public class timer {
	
	public static int seconds = 0;
	public static int minutes = 0;
	public static int timerStop = 0;
	
		public static void timer() {
			
			
			testBase.startTime = _utils.getTimestamp(testBase.startTime);
			
			try {
			do {
				Thread.sleep(1000);
				seconds++;
				
				if (seconds == 60) {
					seconds = 0;
					minutes++;
				}
				
			} while (timerStop <= 0);
			} catch (InterruptedException e) {
				_utils.print("Timer error!");
				e.printStackTrace();
			}
		}
}
