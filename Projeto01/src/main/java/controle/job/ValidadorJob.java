package controle.job;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import persistencia.DaoAlertas;
import persistencia.DaoUltimasMovimentacoesDiferenca;
import util.HibernateUtil;
import entidades.Alertas;
import entidades.UltimasMovimentacoesDiferenca;


public class ValidadorJob implements Job {
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//Simula validações   
		try{
			JobDataMap dataMap = arg0.getJobDetail().getJobDataMap();
			Session session = HibernateUtil.getSession();//(Session) dataMap.get("session");
			int segundos =  dataMap.getInt("segundos");
			DaoUltimasMovimentacoesDiferenca dao = new DaoUltimasMovimentacoesDiferenca(UltimasMovimentacoesDiferenca.class,session);
			DaoAlertas daoAlerta = new DaoAlertas(Alertas.class, session);
			List<UltimasMovimentacoesDiferenca> lista =dao.acimaTempo(session, segundos);
			for(int i=0;i<lista.size();i++){

				session.beginTransaction();
				daoAlerta.salvar(new Alertas(1,lista.get(i).getCdMovimentacao()));	
				session.getTransaction().commit();			
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}


}

