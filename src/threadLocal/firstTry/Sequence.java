package threadLocal.firstTry;

import threadLocal.MyThreadLocal;

public class Sequence {

	private static MyThreadLocal<Integer> numberContainer = new MyThreadLocal<Integer>()
			{
		@Override
		protected Integer initialValue()
		{
			return 2;
		}
			};
	public int getNumber()
	{
		numberContainer.set(numberContainer.get()+1);
		return numberContainer.get();
	}
	
	public static void main (String args[])
	{
		System.out.println("T"+String.valueOf((char)29)+"T");
		Sequence sequence = new Sequence();
		for(int i=0 ;i<2;i++)
		{
			new ClientThread(sequence).start();
		}

	}
}

class ClientThread extends Thread{
	
	private Sequence sequence;
	
	public ClientThread(Sequence sequence) {
		super();
		this.sequence = sequence;
	}

	@Override
	public void run()
	{
		for(int i =0; i<3;i++)
		{
			System.out.println(Thread.currentThread().getName()+">>"+sequence.getNumber());
		}
	}
}
