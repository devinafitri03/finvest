package apap.tk.finvest.repository;

import apap.tk.finvest.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectDb extends JpaRepository<ProjectModel, Long> {
    ProjectModel findByNama(String nama);

    Optional<ProjectModel> findByUuid(Integer uuid);

    List<ProjectModel> findAllByCompanyUuid(Integer companyId);

    List<ProjectModel> findAllByIsFinished(Boolean isFinished);

    void deleteByUuid(Integer uuid);
}
