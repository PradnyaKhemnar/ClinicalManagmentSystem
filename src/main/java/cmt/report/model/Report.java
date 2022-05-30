package cmt.report.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import cmt.store.model.TestStoreDetails;

@Entity
@Table(name = "report")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Reportid;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date Reportdate;
	private String TestResult;

	public int getReportid() {
		return Reportid;
	}

	public void setReportid(int reportid) {
		Reportid = reportid;
	}

	public Date getReportdate() {
		return Reportdate;
	}

	public void setReportdate(Date reportdate) {
		Reportdate = reportdate;
	}

	public String getTestResult() {
		return TestResult;
	}

	public void setTestResult(String testResult) {
		TestResult = testResult;
	}

	public Report(int reportid, TestStoreDetails tsd, Date reportdate, String testResult) {
		super();
		Reportid = reportid;
		Reportdate = reportdate;
		TestResult = testResult;
	}

	public Report() {
		super();
// TODO Auto-generated constructor stub
	}

	

}