package controle.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
 
 
public class ValidadorJob implements Job {
 
       @Override
       public void execute(JobExecutionContext arg0) throws JobExecutionException {
              //Simula validações
             System.out.println("Validando dados duplicados no banco. At "+new Date());
             System.out.println("Deletando registros com mais de 10 dias sem uso. At "+new Date());
             
       }
 
}

