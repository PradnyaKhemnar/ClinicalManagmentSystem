package cmt.customer.service;



import java.util.List;



import cmt.customer.model.Customer;



public interface ICustomerService {



public Customer addCust(Customer c);
public Customer deleteCust(String customerId);
public Customer updateCust(Customer c);
public List<Customer> printAllCustomer();
public Customer getById(String customerId);
public Customer checkCustomerLogin(String CustomerId,String password);
public Customer getByName (String customerName);



}