package ar.com.educacionit.web.managedbeans;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import ar.com.educacionit.app.domain.User;
import ar.com.educacionit.service.UserService;
import ar.com.educacionit.service.impl.UserServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String error;
	
	private String password;
	
	private String user;
	
	private UserService userService = new UserServiceImpl();
	
	//metodo de login
	public String login2() {
		
		//User user;
		String redirect;
		
		if(this.user.equals("eduit")
			&& this.password.equals("eduit")) {
			
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("usuario", "Usuario EduIt");
			sessionMap.put("nickName", "NickName EduIt");
			redirect = "login-success.xhtml";
		}else {
			this.error = "Usuario / Password invalidos";
			redirect = "login";
		}
		
		return redirect;
	}
	
	
	public String login() {
		
		User user;
		try {
			user = userService.getUserByUserName("ADMIN");
			
			if(user !=null && user.getPassword().equals(password)) {
				Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put("usuario", user);
				return "login-success";
			    
			}else {
				error = "Bad User/password";
				return "login";
			}
		} catch (ServiceException e) {
			error = e.getMessage();
			return "login";
		}
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
