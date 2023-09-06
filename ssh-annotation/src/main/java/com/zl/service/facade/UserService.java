package com.zl.service.facade;

import com.zl.dto.domain.User;

public interface UserService {
	public void saveRegisterInfo(User u);
	public User userLogin(User u);
}
