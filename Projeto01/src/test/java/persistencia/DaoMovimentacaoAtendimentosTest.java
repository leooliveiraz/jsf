package persistencia;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import entidades.Paciente;
import util.HibernateUtil;

public class DaoMovimentacaoAtendimentosTest {
	List<Paciente> listaPaciente;
	@Test
	public void testBuscar() {
		try{

			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoPaciente dao = new DaoPaciente(Paciente.class,session);
			this.listaPaciente = dao.buscaTodos();
			session.close();
			
			for (int i = 0;i<listaPaciente.size();i++){
				System.out.println(listaPaciente.get(i).getCdPaciente()+" "+listaPaciente.get(i).getNmPaciente()+" "+listaPaciente.get(i).getCpf());
			}
		} 	catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
		}
	}

}
