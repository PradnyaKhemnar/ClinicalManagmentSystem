package cmt.test.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import cmt.test.model.Test;



public interface TestDao extends JpaRepository<Test, Integer>{


public Test findByTestName(String name);

}