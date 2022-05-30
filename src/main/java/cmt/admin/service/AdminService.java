package cmt.admin.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmt.admin.dao.AdminDao;
import cmt.admin.exception.EmptyInputException;
import cmt.admin.exception.EmptyListException;
import cmt.admin.model.Admin;
@Service
public class AdminService implements IAdminService{

	@Autowired
	AdminDao dao;
	@Override
	public Admin addadminDetails(Admin a) {
		// TODO Auto-generated method stub
		dao.save(a);
		
		return a;
	}

	@Override
	public Admin updateAdmin(Admin a) {
		// TODO Auto-generated method stub
		Admin a1=dao.findById(a.getAdminId()).orElse(null);
		a1.setAdminName(a.getAdminName());
		a1.setMobilenumber(a.getMobilenumber());
		a1.setAdminAddress(a.getAdminAddress());
		a1.setAdminEmail(a.getAdminEmail());
		a1.setAdminUserName(a.getAdminUserName());
		a1.setAdminPassword(a.getAdminPassword());
		dao.save(a1);
		
		
		return a1;
	}

	@Override
	public Admin deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		Admin a=dao.findById(adminId).get();//nosuchelementException
		dao.delete(a);
		return a;
	}

	@Override
	public List<Admin> getAdmin() {
		// TODO Auto-generated method stub
		List<Admin> lst=new ArrayList<Admin>(); 
		Iterable<Admin> tis=dao.findAll();
		for(Admin st:tis) {
			System.out.println(st);
			lst.add(st);
		}
		if(lst.isEmpty())
		{
			throw new EmptyListException("607", "List is empty");
		}
		return lst;
		
		
	}

	@Override
	public Admin getById(int adminId) {
		// TODO Auto-generated method stub
		Admin a=dao.findById(adminId).get();//nosuchelementexception
		return a;
	}

	@Override
	public Admin checkAdminLogin(String username, String password) {
		// TODO Auto-generated method stub
		
		if(username.isEmpty()||password.isEmpty())
		{
			throw new EmptyInputException("608","empty inputexception please check the username and password entered");
		}
		Admin a=dao.findByAdminUserNameAndAdminPassword(username, password);
		return a;
	}

}
