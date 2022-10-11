package lock;

class Save {
	
	Calc calc;
	
	Save(Calc calc){
		this.calc = calc;
	}
	
	Save(){
		
	}
	
	int num = 0;

	synchronized void valueSave(int num) {	// 상호배제를 위한 synchronized 설정
		this.num = num;
		
		System.out.println(Thread.currentThread().getName()+ " save method 실행");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+ " plus method 호출");
		calc.plus(num);
		
		System.out.println(Thread.currentThread().getName()+ " save mehtod 종료");
		System.out.println(num);
	}
	
	
}
