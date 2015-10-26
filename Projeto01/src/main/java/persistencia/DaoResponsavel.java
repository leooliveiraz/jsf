package persistencia;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entidades.Paciente;
import entidades.Responsavel;
import entidades.ResponsavelPaciente;

public class DaoResponsavel extends GenericDao<Responsavel>{

	public DaoResponsavel(Class<Responsavel> classe,
			Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
	

}
