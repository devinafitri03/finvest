package apap.tk.finvest.service;

import java.util.List;
import java.util.Optional;

import apap.tk.finvest.model.ProjectModel;

public interface ProjectService {

    List<ProjectModel> getListProject();

    List<ProjectModel> getListProjectByIsFinished(Boolean isFinished);

    Optional<ProjectModel> getProjectByUuid(Integer uuid);

    ProjectModel addProject(ProjectModel project);

    ProjectModel updateProject(ProjectModel project);
}
