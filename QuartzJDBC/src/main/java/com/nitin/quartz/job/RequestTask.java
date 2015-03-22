package com.nitin.quartz.job;

public class RequestTask implements Runnable {
	int i;

	public RequestTask(int count)

	{
		this.i = count;
	}

	public void run() {

		System.out.println("count=" + i);
	}

}