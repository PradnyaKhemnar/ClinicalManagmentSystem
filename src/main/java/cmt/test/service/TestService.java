package cmt.test.service;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmt.admin.exception.EmptyListException;
import cmt.test.dao.TestDao;
import cmt.test.model.Test;
import cmt.testdetails.model.TestDetails;



@Service
public class TestService implements ITestService {
@Autowired
private TestDao tdao;


@Transactional
@Override
public Test addTest(Test t) {
	
return tdao.save(t);
}



@Override
public Test updateTest(Test t) {
Test test = tdao.findById(t.getTestId()).get();
test.setTestName(t.getTestName());
test.setTestPrice(t.getTestPrice());
test.setTestType(t.getTestType());

tdao.save(test);
return test; }



@Override
public Test deleteTest(int testId) {
Test test = tdao.findById(testId).get();
tdao.delete(test);
return test;
}



@Override
public Test printTest(int testId) {
return tdao.findById(testId).get();
}



@Override
public List<Test> allTest() {
List<Test> lst = new ArrayList<Test>();
Iterable<Test> tests = tdao.findAll();
for (Test test : tests) {
lst.add(test);
}
if(lst.isEmpty()) {
throw new EmptyListException("607", "list is empty");
}
return lst;
}



@Override
public Test findbyname(String name) {
	return null;
	// TODO Auto-generated method stub
	
}



@Override
public Test finbytest1name(String name) {
	// TODO Auto-generated method stub
	return tdao.findByTestName(name);
}








}