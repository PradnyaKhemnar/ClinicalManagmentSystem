
package cmt.report.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import cmt.report.model.Report;
public interface ReportDao extends JpaRepository<Report, Integer>{
}

