package lock;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Save save = new Save();
		Calc calc = new Calc();
		
		calc.save = save;
		save.calc = calc;
		
		// Thread-0
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				calc.plus(5);
				
			}
		}).start();

		// Thread-1
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				save.valueSave(5);
				
			}
		}).start();

	}

}
