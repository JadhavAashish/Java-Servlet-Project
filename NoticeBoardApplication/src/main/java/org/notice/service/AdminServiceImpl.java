package org.notice.service;

import org.notice.model.LoginModel;
import org.notice.repository.AdminRepository;
import org.notice.repository.AdminRepositoryImpl;

public class AdminServiceImpl implements AdminService{
	
	AdminRepository adminRepo=new AdminRepositoryImpl();
	
	public LoginModel validateAdmin(LoginModel model)
	{
		model=adminRepo.isValidate(model);
		return model;
	}

}
