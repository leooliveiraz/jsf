package persistencia;

import org.hibernate.Session;

import entidades.ResponsavelPaciente;

public class DaoResponsavelPaciente extends GenericDao<ResponsavelPaciente>{

	public DaoResponsavelPaciente(Class<ResponsavelPaciente> classe,
			Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
