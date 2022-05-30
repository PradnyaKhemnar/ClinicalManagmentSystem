package cmt.report.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmt.admin.exception.EmptyListException;
import cmt.report.dao.ReportDao;
import cmt.report.model.Report;



@Service
public class ReportService implements IReportService {

@Autowired private ReportDao rdao;



@Override

public Report addReport(Report r) {
// TODO Auto-generated method stub
return rdao.save(r);
}



@Override
public Report updateReport(Report r) {
Report report = rdao.findById(r.getReportid()).get();
report.setReportdate(r.getReportdate());
report.setTestResult(r.getTestResult());
rdao.save(report);
return report;
}



@Override
public Report DeleteReport(int Reportid) {
Report report = rdao.findById(Reportid).get();
rdao.delete(report);
return report;

}



@Override
public Report getReportByReportId(int reportId) {
Report report=rdao.findById(reportId).get(); //nosuchelementexception
return report;
}








@Override
public Report getreportByPlacedId(int TestDetailsId) {
	// TODO Auto-generated method stub
	Report report=rdao.findById(TestDetailsId).get(); //nosuchelementexception
	return report;

}



@Override
public List<Report> getallReports() {
List<Report> custlist=new ArrayList<Report>();
Iterable<Report> culi=rdao.findAll();
for(Report r:culi)
{
custlist.add(r);
}
if(custlist.isEmpty())
{
throw new EmptyListException("607", "List is Empty");
}
return custlist;
}
}