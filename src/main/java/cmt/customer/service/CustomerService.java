package cmt.customer.service;



import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import cmt.admin.exception.EmptyInputException;
import cmt.admin.exception.EmptyListException;
import cmt.customer.dao.CustomerDao;
import cmt.customer.model.Customer;



@Service
public class CustomerService implements ICustomerService {

@Autowired
CustomerDao dao;



@Override
public Customer addCust(Customer c) {

return dao.save(c);
}



@Override
public Customer updateCust(Customer c) {
Customer cust=dao.findById(c.getCustomerId()).orElse(null);
cust.setCustomerName(c.getCustomerName());
cust.setCustomerMobileNumber(c.getCustomerMobileNumber());
cust.setCustomerEmail(c.getCustomerEmail());
cust.setCustomerAddress(c.getCustomerAddress());
cust.setCustomerPassword(c.getCustomerPassword());
dao.save(cust);
return cust;
}



@Override
public Customer deleteCust(String customerId) {

Customer cust=dao.findById(customerId).get();//nosuchelementexception
dao.delete(cust);
return cust;
}

@Override
public List<Customer> printAllCustomer() {
List<Customer> custlist=new ArrayList<Customer>();
Iterable<Customer> culi=dao.findAll();
for(Customer c:culi)
{
custlist.add(c);
}
if(custlist.isEmpty())
{
throw new EmptyListException("607", "List is Empty");
}
return custlist;
}



@Override
public Customer getById(String customerId) {



Customer cust=dao.findById(customerId).get(); //nosuchelementexception
return cust;
}


@Override
public Customer getByName(String customerName) {
Customer cust=dao.findByCustomerName(customerName); //nosuchelementexception
return cust;
}




@Override
public Customer checkCustomerLogin(String CustomerId, String password) {
if(CustomerId.isEmpty() || password.isEmpty())
{
throw new EmptyInputException("608", "Please check Customer Id and Password");
}
Customer cust= dao.findByCustomerIdAndCustomerPassword(CustomerId, password);

return cust;
}




}