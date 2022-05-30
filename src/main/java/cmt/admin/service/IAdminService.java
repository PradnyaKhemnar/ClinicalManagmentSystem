package cmt.admin.service;
import java.util.List;

import cmt.admin.model.Admin;
public interface IAdminService {

	public Admin addadminDetails(Admin a);
	public Admin updateAdmin(Admin a);
	public Admin deleteAdmin (int adminId);
	public List<Admin> getAdmin();
	public Admin  getById(int adminId);
	public Admin  checkAdminLogin(String username ,String  password);

}
