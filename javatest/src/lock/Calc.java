package lock;

public class Calc {

	Save save;
	
	Calc(Save save){
		this.save = save;
	}
	
	Calc(){
		
	}
	
	synchronized int plus(int num)  {    // ��ȣ������ ���� synchronized ����
		
		num = num + 1;
		System.out.println(Thread.currentThread().getName()+ " plus mehtod ����");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+ " save mehtod ȣ��");
		save.valueSave(num);

		
		
		System.out.println(Thread.currentThread().getName()+ " plus mehtod ����");
		System.out.println(num);
		
		return num;
	}
}
