package com.nitin.quartz.job;

import static org.quartz.JobBuilder.newJob;

import java.util.Date;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class JobCreater {

	@Autowired
	private Scheduler scheduler;

	public void createJob(Date endtime) {
		SimpleTriggerImpl trigger = new SimpleTriggerImpl();
		trigger.setStartTime(endtime);

		TriggerKey triggerKey = new TriggerKey("test trigger key " + Math.random());
		trigger.setKey(triggerKey);

		JobDataMap jobEndDataMap = trigger.getJobDataMap();

		jobEndDataMap.put("datamapky1", "datamapvalue1");
		jobEndDataMap.put("datamapky2", "datamapvalue2");

		JobKey jobKey = new JobKey("test job key" + Math.random());

		trigger.setJobKey(jobKey);

		try {
			if (!scheduler.checkExists(jobKey)) {
				JobDetail jobDetail = newJob(JobExecuter.class).withIdentity(jobKey).storeDurably().build();
				scheduler.addJob(jobDetail, true);
				scheduler.scheduleJob(trigger);
			} else {
				System.out.println("Already exist");
			}
			System.out.println("creted job for " + endtime + " at " + new Date());
		} catch (SchedulerException e) {

			e.printStackTrace();
		}

	}
}
