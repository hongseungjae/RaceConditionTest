package lock;

class Save {
	
	Calc calc;
	
	Save(Calc calc){
		this.calc = calc;
	}
	
	Save(){
		
	}
	
	int num = 0;

	synchronized void valueSave(int num) {	// ��ȣ������ ���� synchronized ����
		this.num = num;
		
		System.out.println(Thread.currentThread().getName()+ " save method ����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+ " plus method ȣ��");
		calc.plus(num);
		
		System.out.println(Thread.currentThread().getName()+ " save mehtod ����");
		System.out.println(num);
	}
	
	
}
