package persistencia;

import org.hibernate.Session;

import entidades.ResponsavelPacienteId;

public class DaoResponsavelPacienteId extends GenericDao<ResponsavelPacienteId>{

	public DaoResponsavelPacienteId(Class<ResponsavelPacienteId> classe,
			Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
