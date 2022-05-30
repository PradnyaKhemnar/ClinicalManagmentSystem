package cmt.store.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmt.admin.exception.EmptyListException;
import cmt.store.doa.TestStoreDao;
import cmt.store.model.TestStoreDetails;

@Service
public class TestStoreDetailsService implements ITestStoreDetailsService{

	@Autowired
	TestStoreDao storedao;
	@Override
	
	@Transactional
	public TestStoreDetails storeDat(TestStoreDetails t) {
		// TODO Auto-generated method stub
		return storedao.save(t);
	}

	@Override
	public TestStoreDetails updateStoredData(TestStoreDetails t) {
		// TODO Auto-generated method stub
		
		TestStoreDetails test = storedao.findById(t.getPlaceTestId()).get();
		
		
		
		test.setTestName(t.getTestName());
		test.setTestPrice(t.getTestPrice());
		test.setTestType(t.getTestType());

		storedao.save(test);
		return test; 
		
	}

	@Override
	public TestStoreDetails deleteStoredData(int storeId) {
		// TODO Auto-generated method stub
		TestStoreDetails test = storedao.findById(storeId).get();
		storedao.delete(test);
		return test;
	}

	@Override
	public TestStoreDetails printTStoredData(int testId) {
		// TODO Auto-generated method stub
		return storedao.findById(testId).get();
	}

	@Override
	public List<TestStoreDetails> allTestStoreData() {
		// TODO Auto-generated method stub
		List<TestStoreDetails> lst = new ArrayList<TestStoreDetails>();
		Iterable<TestStoreDetails> tests = storedao.findAll();
		for (TestStoreDetails test : tests) {
		lst.add(test);
		}
		if(lst.isEmpty()) {
		throw new EmptyListException("607", "list is empty");
		}
		return lst;
		}

	@Override
	@Transactional
	public List<TestStoreDetails> findbytesdetailsId(int id) {
		// TODO Auto-generated method stub
		return storedao.findByTesTestDetailsId(id);
	}

	@Override
	@Transactional
	public List<TestStoreDetails> deletebytesdetailsid(int id) {
	
		
	return null;
	}
	
	
	

}
