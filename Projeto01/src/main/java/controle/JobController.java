package controle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import controle.job.ValidadorJob;
import persistencia.DaoAtendimento;
import persistencia.DaoPaciente;
import persistencia.DaoTags;
import persistencia.DaoTagsAtendimento;
import util.HibernateUtil;
import entidades.Atendimento;
import entidades.Tags;
import entidades.TagsAtendimento;

@ManagedBean
@ApplicationScoped
public class JobController implements Serializable {

	private String snJobLigado = "N";
	private String segundos = "1";
	
	@PostConstruct
	public void rodar(){
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
               
        } catch (SchedulerException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
	}
	
	

}
