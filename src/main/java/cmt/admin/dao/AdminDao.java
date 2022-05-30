package cmt.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cmt.admin.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	public Admin findByAdminUserNameAndAdminPassword(String username,String password);

}
