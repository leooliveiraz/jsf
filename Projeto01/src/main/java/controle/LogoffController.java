package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="logoffController")
@RequestScoped
public class LogoffController {
	
	public String realizaLogoff(){
		try{
			System.out.println("certo");
			FacesContext fc = FacesContext.getCurrentInstance();  
			HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);  
			session.invalidate();
			return "login.xhtml?faces-redirect=true";  
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();

			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erro.",
					"Logout não Efetuado.");
			context.addMessage(null, mensagem);	
			
			System.out.println("erro");
			return "";

		}
	}
}
