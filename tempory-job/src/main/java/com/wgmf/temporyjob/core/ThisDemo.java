package com.wgmf.temporyjob.core;

public class ThisDemo implements Runnable {
    synchronized  void doa(){
    	System.out.println("aaa");
    	try {
			this.wait(5000);
		} catch (InterruptedException e) {
			System.out.println("error");
		};
    	dob();
    }
    
    synchronized void dob(){
    	System.out.println("bbb");
    }

    public static void main(String[] args) {
    	ThisDemo demo = new ThisDemo();
    	Thread thread1 = new Thread(demo);
    	Thread thread2 = new Thread(demo);
    	
    	thread1.start();
    	thread2.start();
    }

	@Override
	public void run() {
		doa();
		
	}

}
