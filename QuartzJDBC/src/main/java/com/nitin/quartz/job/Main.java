package com.nitin.quartz.job;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {

		/*
		 * ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		 * JobCreater creater = ctx.getBean(JobCreater.class); Long timeinmillis = System.currentTimeMillis() + 5000;
		 * creater.createJob(new Date(timeinmillis));
		 */
		ExecutorService exec = Executors.newFixedThreadPool(10);
		BoundedExecutor bex = new BoundedExecutor(exec, 10);

		for (int i = 0; i < 100; i++) {

			try {
				System.out.println("################ i=" + i);
				RequestTask task = new RequestTask(i);
				bex.submitTask(task);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		exec.shutdown();

	}

}
