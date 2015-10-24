package persistencia;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import entidades.Paciente;

public class DaoPaciente extends GenericDao<Paciente>{

	public DaoPaciente(Class<Paciente> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

	public int ultimoRegistro(){
		Paciente paciente = null;
		try{
			Session session = HibernateUtil.getSession();

			Criteria criterio = session.createCriteria(Paciente.class);
			criterio.addOrder(Order.desc("cdPaciente"));
			criterio.setFirstResult(1);
			criterio.setMaxResults(1);
			paciente = (Paciente) criterio.uniqueResult();

			return paciente.getCdPaciente();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}



	}

}
