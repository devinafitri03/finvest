package apap.tk.finvest.repository;

import apap.tk.finvest.model.FinanceReportModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceReportDb extends JpaRepository<FinanceReportModel, Integer> {

    // find report by Project ID and Fiscal Period
    @Query("SELECT r FROM FinanceReportModel r WHERE r.proyek = :project AND r.periode_fiskal = :period")
    Optional<FinanceReportModel> findByProjectAndPeriod(@Param("project") Integer project,
            @Param("period") Integer period);

    // @Query("DELETE r FROM FinanceReportModel r WHERE r.proyek = :project")
    // Optional<FinanceReportModel> deleteProject(@Param("project") Integer
    // project);

}