package com.nitin.quartz.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class JobExecuter implements Job {

	public static final String PREFERENCE_BACKUP = "backup";

	private static final Logger LOGGER = LoggerFactory.getLogger(JobExecuter.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {

		System.out.println("JobExecuter called at" + new Date());
		System.out.println(context.getJobDetail());

	}

}
