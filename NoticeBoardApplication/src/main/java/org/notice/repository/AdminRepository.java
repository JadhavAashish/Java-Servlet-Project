package org.notice.repository;

import org.notice.model.LoginModel;

public interface AdminRepository {
	
	public LoginModel isValidate(LoginModel model);
}
