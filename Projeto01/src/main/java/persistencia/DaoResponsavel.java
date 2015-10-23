package persistencia;

import org.hibernate.Session;

import entidades.Responsavel;
import entidades.ResponsavelPaciente;

public class DaoResponsavel extends GenericDao<Responsavel>{

	public DaoResponsavel(Class<Responsavel> classe,
			Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
