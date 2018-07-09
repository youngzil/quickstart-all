package com.rensanning.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Job1 implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job 1 is runing！ " + new Date());
    }
}
