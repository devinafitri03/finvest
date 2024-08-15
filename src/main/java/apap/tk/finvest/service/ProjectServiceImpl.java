package apap.tk.finvest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.tk.finvest.model.ProjectModel;
import apap.tk.finvest.repository.ProjectDb;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDb projectDb;

    @Override
    public List<ProjectModel> getListProject() {
        return projectDb.findAll();
    }

    @Override
    public List<ProjectModel> getListProjectByIsFinished(Boolean isFinished) {
        return projectDb.findAllByIsFinished(isFinished);
    }

    @Override
    public Optional<ProjectModel> getProjectByUuid(Integer uuid) {
        return projectDb.findByUuid(uuid);
    }

    @Override
    public ProjectModel addProject(ProjectModel project) {
        List<ProjectModel> listProjectByIdCompany = projectDb.findAllByCompanyUuid(project.getCompany().getUuid());

        for (ProjectModel projectModel : listProjectByIdCompany) {
            if (projectModel.getNama().equals(project.getNama())) {
                throw new IllegalArgumentException("Project with same name in the same company already exists");
            }
        }

        return projectDb.save(project);
    }

    @Override
    public ProjectModel updateProject(ProjectModel project) {
        List<ProjectModel> listProjectByIdCompany = projectDb.findAllByCompanyUuid(project.getCompany().getUuid());

        for (ProjectModel projectModel : listProjectByIdCompany) {
            if (projectModel.getUuid() != project.getUuid() && projectModel.getNama().equals(project.getNama())) {
                throw new IllegalArgumentException("Project with same name in the same company already exists");
            }
        }

        return projectDb.save(project);
    }

}
