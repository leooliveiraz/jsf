package persistencia;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import entidades.Paciente;

public class DaoPacienteTest {

	@Test
	public void testBuscaTodos() {
		try{
			List<Paciente> listaPaciente;
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoPaciente dao = new DaoPaciente(Paciente.class,session);
			listaPaciente = dao.buscaTodos();
			session.close();

			for (int i = 0;i<listaPaciente.size();i++){
				System.out.println(listaPaciente.get(i).getCdPaciente()+" "+listaPaciente.get(i).getNmPaciente()+" "+listaPaciente.get(i).getCpf());
			}
		} 	catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			e.printStackTrace();
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testeUltimoReg(){
		Session session = HibernateUtil.getSession();
		DaoPaciente dao = new DaoPaciente(Paciente.class, session);
		Paciente paciente =dao.ultimoRegistro();
		System.out.println(paciente.getCdPaciente());
		
	}
	

}
