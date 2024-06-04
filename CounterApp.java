
public class CounterApp {

	public static void main(String[] args) {
		// Thread to count up to 20
		Thread countUpThread = new Thread(new CountUp());
		// Thread to count down from 20 to 0
		Thread countDownThread = new Thread(new CountDown());
		
		// Start the count up thread
		countUpThread.start();
		
		try {
			// Wait for the count up thread to finish
			countUpThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Start the count down thread 
		countDownThread.start();
		
	}
}

class CountUp implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i <= 20; i++) {
			System.out.println("Count Up: " + i);
			try {
				Thread.sleep(500); // Sleep for 500 milliseconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class CountDown implements Runnable {
	@Override
	public void run() {
		for (int i = 20; i >= 0; i--) {
			System.out.println("Count Down: " + i);
			try {
				Thread.sleep(500); // Sleep for 500 milliseconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
