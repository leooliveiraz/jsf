package controle.job;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
 
 
public class QuartzApp {
 
       /**
        * @param args
        */
	static String  sn_ativo = "S";
	
       public static void main(String[] args) {
             SchedulerFactory shedFact = new StdSchedulerFactory();
             try {
                    Scheduler scheduler = shedFact.getScheduler();
                    scheduler.start();
                    JobDetail job = JobBuilder.newJob(ValidadorJob.class)
                                  .withIdentity("validadorJOB", "grupo01")
                                  .build();
                    Trigger trigger = TriggerBuilder.newTrigger()
                                  .withIdentity("validadorTRIGGER","grupo01")
                                  .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                                  .build();
                    scheduler.scheduleJob(job, trigger);
                    if(sn_ativo=="N"){
                    	scheduler.shutdown();
                    }
             } catch (SchedulerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
             }
       }
 
}

