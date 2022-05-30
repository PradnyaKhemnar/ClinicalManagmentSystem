package cmt.customer.dao;



import org.springframework.data.jpa.repository.JpaRepository;



import cmt.customer.model.Customer;



public interface CustomerDao extends JpaRepository<Customer, String> {



public Customer findByCustomerIdAndCustomerPassword(String custid,String custpassword);
public Customer findByCustomerName(String custname);




}