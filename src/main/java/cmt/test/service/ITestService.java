package cmt.test.service;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cmt.test.model.Test;
import cmt.testdetails.model.TestDetails;



public interface ITestService {
public Test addTest(Test t);



public Test updateTest(Test t);



public Test deleteTest(int testId);



public Test printTest(int testId);



public List<Test> allTest();

public Test findbyname(String name);
public Test finbytest1name(String name);







}