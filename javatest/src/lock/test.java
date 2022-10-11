package lock;

public class test {

	static int a = 1;
	
	volatile static int result = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Thread-0
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(a < result) {
					
					System.out.println("현재값 : "+a +" "+ " 현재 쓰레드 : "+Thread.currentThread().getName());
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					test.a = test.a + 1;
					
					System.out.println("다음값 : "+a +" "+ " 현재 쓰레드 : "+Thread.currentThread().getName());
				}
			}
		}).start();
		
		
		//Thread-1
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(a < result) {
					
					System.out.println("현재값 : "+a +" "+ " 현재 쓰레드 : "+Thread.currentThread().getName());
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					test.a = test.a + 1;
					
					System.out.println("다음값 : "+a +" "+ " 현재 쓰레드 : "+Thread.currentThread().getName());
				}
			}
		}).start();
		
		for(int i = 0 ; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(a);	
		}
		
	}

}
