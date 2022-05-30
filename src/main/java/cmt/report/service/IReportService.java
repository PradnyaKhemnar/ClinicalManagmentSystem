package cmt.report.service;



import java.util.Date;
import java.util.List;



import cmt.report.model.Report;



public interface IReportService {
public Report addReport(Report r) ;
public Report updateReport(Report r);
public Report DeleteReport(int Reportid);
public Report getReportByReportId(int reportId);
public Report getreportByPlacedId(int TestDetailsId) ;
public List<Report> getallReports();
}