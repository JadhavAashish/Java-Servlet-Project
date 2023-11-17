package org.notice.repository;

import java.sql.SQLException;
import java.util.*;

import org.notice.dbconfigure.DBConfig;
import org.notice.model.CategoryModel;

public class CategoryRepositoryImpl extends DBConfig implements CategoryRepository{

	List<CategoryModel> list=new ArrayList<CategoryModel>();
	
	@Override
	public boolean isAddCategory(CategoryModel model) {
		try
		{
			stmt=conn.prepareStatement("insert into category values('0',?,?)");
			stmt.setString(1, model.getName());
			stmt.setInt(2, 1);
			int value=stmt.executeUpdate();
			
			
			return value>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);	
			return false;
		}
	}

	
	@Override
	public List<CategoryModel> getAllCategory() {
		try
		{
			stmt=conn.prepareStatement("select *from category where status=1");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CategoryModel catMod=new CategoryModel();
				catMod.setId(rs.getInt(1));
				catMod.setName(rs.getString(2));
				list.add(catMod);
			}
			return list.size()>0?list:null;
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return null;	
		}
		
	}


	@Override
	public boolean isDisableCategory(int catId) {
		try 
		{
			stmt=conn.prepareStatement("update category set status=0 where cid=?");
			stmt.setInt(1, catId);
			int value=stmt.executeUpdate();
			
			return value>0?true:false;
		} 
		catch (Exception e) {
			
			System.out.println("Error is "+e);
			return false;
		}	
	}


	@Override
	public List<CategoryModel> getAllCategoryByName(String name) {
		try
		{
			stmt=conn.prepareStatement("select *from category where status=1 and name like '%"+name+"%'");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CategoryModel catMod=new CategoryModel();
				catMod.setId(rs.getInt(1));
				catMod.setName(rs.getString(2));
				list.add(catMod);
			}
			return list.size()>0?list:null;
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return null;	
		}
	}


	@Override
	public boolean getUpdated (CategoryModel model) {
		//System.out.println(model.getName()+" "+model.getId());
		try
		{
			stmt=conn.prepareStatement("update category set name=? where cid=? and status=?");
			stmt.setString(1, model.getName());
			stmt.setInt(2, model.getId());
			stmt.setInt(3, 1);
			int value=stmt.executeUpdate();
			
			
			return value>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);	
			return false;
		}
	}

}
