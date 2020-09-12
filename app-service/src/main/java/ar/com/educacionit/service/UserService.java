package ar.com.educacionit.service;

import ar.com.educacionit.app.domain.User;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface UserService {

	public User getUserByUserName(String username) throws ServiceException;
}
