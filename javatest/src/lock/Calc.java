package lock;

public class Calc {

	Save save;
	
	Calc(Save save){
		this.save = save;
	}
	
	Calc(){
		
	}
	
	synchronized int plus(int num)  {    // 상호배제를 위한 synchronized 설정
		
		num = num + 1;
		System.out.println(Thread.currentThread().getName()+ " plus mehtod 실행");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+ " save mehtod 호출");
		save.valueSave(num);

		
		
		System.out.println(Thread.currentThread().getName()+ " plus mehtod 종료");
		System.out.println(num);
		
		return num;
	}
}
