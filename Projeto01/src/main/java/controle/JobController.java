package controle;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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

import util.HibernateUtil;
import controle.job.ValidadorJob;

@ManagedBean
@ApplicationScoped
public class JobController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -579538504598191195L;
	private String snJobLigado = "DESLIGADO";
	private int segundos = 5;
	private Session session= HibernateUtil.getSession();
	Scheduler scheduler;


	public String getSnJobLigado() {
		return snJobLigado;
	}
	public void setSnJobLigado(String snJobLigado) {
		this.snJobLigado = snJobLigado;
	}
	public int getSegundos() {
		return segundos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	public void rodar(){
		SchedulerFactory shedFact = new StdSchedulerFactory();
		try {
			if(scheduler==null||scheduler.isShutdown()){
				scheduler = shedFact.getScheduler();
				scheduler.start();
				
				JobDetail job = JobBuilder.newJob(ValidadorJob.class)
						.withIdentity("validadorJOB", "grupo01")
						.build();
				job.getJobDataMap().put("session", session);
				job.getJobDataMap().put("segundos", segundos);
				Trigger trigger = TriggerBuilder.newTrigger()
						.withIdentity("validadorTRIGGER","grupo01")
						.withSchedule(CronScheduleBuilder.cronSchedule("0/"+segundos+" * * * * ?"))
						.build();
				
				scheduler.scheduleJob(job, trigger);
				snJobLigado = "LIGADO";
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Iniciado JOB para identificar tags sem movimentação."));
				
			}
			else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Não Realizado", "Iniciado JOB para identificar tags sem movimentação."));
			}	
				
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Houve um problema ao tentar iniciar o JOB: "+e.getMessage()));	
		}
	}
	
	
	@PreDestroy
	public String parar(){

		try {
			if(scheduler.isStarted()){
				scheduler.shutdown();
				snJobLigado ="DESLIGADO";
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Job Desligado com sucesso."));
				return "configuracoes.xhtml";
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Não Realizadoo", "JOB já está desligado"));
				return "configuracoes.xhtml";
			}


		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Houve um problema para parar o job: "+e.getMessage()));
			return "configuracoes.xhtml";
		}
	}



}
