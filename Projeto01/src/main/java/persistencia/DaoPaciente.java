package persistencia;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import util.HibernateUtil;
import entidades.Paciente;

public class DaoPaciente extends GenericDao<Paciente>{

	public DaoPaciente(Class<Paciente> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

	public Paciente ultimoRegistro(){
		Paciente paciente = null;
		try{
			Session session = HibernateUtil.getSession();
			
			System.out.println(session.createQuery("SELECT (PACIENTE) FROM PACIENTE WHERE PACIENTE.CD_PACIENTE = (SELECT MAX(P.CD_PACIENTE) FROM PACIENTE P").uniqueResult());
		}catch(Exception e){
			e.printStackTrace();
		}

		return paciente;

	}

}
