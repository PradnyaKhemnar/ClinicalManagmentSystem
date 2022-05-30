package cmt.store.service;

import java.util.List;

import cmt.store.model.TestStoreDetails;
import cmt.test.model.Test;

public interface ITestStoreDetailsService {

public TestStoreDetails storeDat(TestStoreDetails t);



public TestStoreDetails updateStoredData(TestStoreDetails t);



public TestStoreDetails deleteStoredData(int storeId);



public TestStoreDetails printTStoredData(int testId);



public List<TestStoreDetails> allTestStoreData();
public List<TestStoreDetails> findbytesdetailsId(int id);
public List<TestStoreDetails> deletebytesdetailsid(int id);


}
