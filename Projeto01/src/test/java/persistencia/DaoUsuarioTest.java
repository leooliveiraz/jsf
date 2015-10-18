package persistencia;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import util.Utilitarios;
import entidades.Usuario;

public class DaoUsuarioTest {
	@Test
	public void testSalvar() {
		try{
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Usuario dto = new Usuario("LPEREIRA","LEONARDO ROCHA ","40570094852",new Date(),new Date(),Utilitarios.sha256("teste"));
			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class,session);		
			dao.salvar(dto);
			System.out.println("Salvo" + dto);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
			fail("Erro ao Salvar");
		}
	}
	

	/*
	@Test
	public void testBuscaLogin() {
		try{
			
			Session session = HibernateUtil.getSession();
			Usuario usuario ;
			DaoUsuario dao = new DaoUsuario(Usuario.class,session);		
			usuario = dao.buscaLogin("LPROCHA", "teste");
			session.close();

			System.out.println(usuario.getCdUsuario()+" "+usuario.getNmUsuario()+" "+usuario.getCpf()+" "+usuario.getDtCadastro()+" "+usuario.getDtNascimento());
		}
		catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
			fail("Erro ao Salvar");
		}
	}
	

	 * 
		@Test
	public void testSalvar() {
		try{
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Usuario dto = new Usuario("#SQN","ANDRE MAGAL ","40570094852",new Date(),new Date(),Utilitarios.sha256("teste"));
			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class,session);		
			dao.salvar(dto);
			System.out.println("Salvo" + dto);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
			fail("Erro ao Salvar");
		}
	}
	
	@Test
	public void testAtualizar() {
		try{
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Usuario dto = new Usuario("LPROCHA","Leonardo Rocha ","40570094852",new Date(),new Date(),"md5('123mudar')");
			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class,session);		
			dao.atualizar(dto);
			System.out.println("Atualizado" + dto);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
			fail("Erro ao Atualizar");
		}
	}

	@Test
	public void testDelete() {
		try{
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Usuario dto = new Usuario("GLEANDRO","GINA ","40570094852",new Date(),new Date(),"md5('123mudar')");
			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class,session);		
			dao.delete(dto);
			System.out.println("Excluido" + dto);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
			fail("Erro ao Excluir");
		}
	}

	@Test
	public void testBuscaPorId() {
		try{
			Session session = HibernateUtil.getSession();
			Usuario dto ;
			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class,session);		
			dto = dao.buscaPorId("LPROCHA");
			System.out.println("Busca:" + dto.getCdUsuario()+ " "+ dto.getNmUsuario()+ " "+ dto.getCpf()+ " "+ dto.getDtCadastro());
			session.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
			fail("Não foi possivel completar a busca");
		}
	}

	@Test
	public void testBuscaPaginada() {
		try{
			Session session = HibernateUtil.getSession();
			List<Usuario> lista ;
			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class,session);		
			lista = dao.buscaPaginada(1,5);
			session.close();
			
			for (int i = 0;i<lista.size();i++){
				System.out.println(lista.get(i).getCdUsuario()+" "+lista.get(i).getNmUsuario()+" "+lista.get(i).getCpf());
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
			fail("Não foi possivel completar a busca");
		}
	}

	@Test
	public void testBuscaTodos() {
		try{
			Session session = HibernateUtil.getSession();
			List<Usuario> lista ;
			DaoUsuario dao = new DaoUsuario(Usuario.class,session);		
			lista = dao.buscaTodos();
			session.close();
			
			for (int i = 0;i<lista.size();i++){
				System.out.println(lista.get(i).getCdUsuario()+" "+lista.get(i).getNmUsuario()+" "+lista.get(i).getCpf());
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
			fail("Não foi possivel completar a busca");
		}
	}*/

}
