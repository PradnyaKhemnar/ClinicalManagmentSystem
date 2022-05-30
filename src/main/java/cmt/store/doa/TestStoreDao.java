package cmt.store.doa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cmt.store.model.TestStoreDetails;

public interface TestStoreDao extends JpaRepository<TestStoreDetails, Integer> 
{
	public List<TestStoreDetails> findByTesTestDetailsId(int id);
	
}
