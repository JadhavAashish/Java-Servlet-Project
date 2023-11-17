package org.notice.repository;

import org.notice.dbconfigure.DBConfig;
import org.notice.model.LoginModel;

public class AdminRepositoryImpl extends DBConfig implements AdminRepository{
	
	public LoginModel isValidate(LoginModel model)
	{
		try
		{
			stmt=conn.prepareStatement("select *from adminprofile where email=? and password=?");
			stmt.setString(1, model.getEmail());
			stmt.setString(2, model.getPassword());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContact(rs.getInt(4));
				model.setPassword(rs.getString(5));
				return model;
			}
			else
			{
				return null;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return null;
		}
		
		
	}
	
	
}
