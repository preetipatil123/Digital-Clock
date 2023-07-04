class P1 {
	public static void main(String args[])
	{
		SplashFrame sf =new SplashFrame();
	
	try{
		Thread.sleep(3000);
		App1 a= new App1();
		sf.dispose();
	}catch(InterruptedException e)
	{
		System.out.println("issue" + e);
	}
		
	}

}
