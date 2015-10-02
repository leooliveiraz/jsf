package persistencia;

import org.hibernate.Session;

import entidades.Paciente;

public class DaoPaciente extends GenericDao<Paciente>{

	public DaoPaciente(Class<Paciente> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
