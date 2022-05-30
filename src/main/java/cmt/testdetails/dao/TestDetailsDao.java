package cmt.testdetails.dao;



import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cmt.testdetails.model.TestDetails;



public interface TestDetailsDao extends JpaRepository<TestDetails, Integer> {
public List<TestDetails> findByCusCustomerId(String custId);
public List<TestDetails> findByTestPlaceTestId(int testid);
public List<TestDetails> deleteByCusCustomerId(String custid);
public List<TestDetails> deleteByTestPlaceTestId(int testid);
public List<TestDetails> deleteByCusCustomerIdAndTestPlaceTestId(String customerId,int testId);



}