package ar.com.educacionit.service.impl;

import ar.com.educacionit.app.domain.User;
import ar.com.educacionit.dao.exceptions.GenericExeption;
import ar.com.educacionit.dao.hibernate.impl.UserHibernateRepositoryImpl;
import ar.com.educacionit.dao.user.UserRepository;
import ar.com.educacionit.service.UserService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl() {
		this.userRepository = new UserHibernateRepositoryImpl();
	}
	
	@Override
	public User getUserByUserName(String userName) throws ServiceException {
		try {
			return this.userRepository.getuser(userName);
		} catch (GenericExeption e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
