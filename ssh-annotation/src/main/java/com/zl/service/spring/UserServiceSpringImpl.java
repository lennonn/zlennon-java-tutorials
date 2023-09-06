package com.zl.service.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zl.dto.domain.User;
import com.zl.persistence.hibernate.dao.UserDAO;
import com.zl.service.facade.UserService;
@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class UserServiceSpringImpl implements UserService {
	private UserDAO userDAO;
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	public void saveRegisterInfo(User u) {
		userDAO.saveRegisterInfo(u);
	}
	@Override
	public User userLogin(User u) {
		User user= userDAO.userLogin(u);
		return user;
	}

}
