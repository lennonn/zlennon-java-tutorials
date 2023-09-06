package com.zl.persistence.hibernate.dao;

import com.zl.dto.domain.User;

public interface UserDAO {
	public void saveRegisterInfo(User u);
	public User userLogin(User u);
}
