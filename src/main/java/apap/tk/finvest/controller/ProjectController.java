package apap.tk.finvest.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import apap.tk.finvest.model.CompanyModel;
import apap.tk.finvest.model.KategoriModel;
import apap.tk.finvest.model.ProjectModel;
import apap.tk.finvest.model.SubkategoriModel;
import apap.tk.finvest.service.CompanyService;
import apap.tk.finvest.service.KategoriService;
import apap.tk.finvest.service.ProjectService;
import apap.tk.finvest.service.SubkategoriService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private KategoriService kategoriService;

    @Autowired
    private SubkategoriService subkategoriService;

    @Autowired
    private CompanyService companyService;

    @GetMapping(value="")
    public String getListRunningProject(@RequestParam(defaultValue = "false") Boolean isFinished,
            Model model) {
        List<ProjectModel> listProject = projectService.getListProjectByIsFinished(isFinished);
        model.addAttribute("listProject", listProject);
        model.addAttribute("isFinished", isFinished);
        return "viewall-project";
    }


    @GetMapping(value = "/add")
    public String addProjectFormPage(Model model) {
        model.addAttribute("operation", "update");

        List<KategoriModel> listKategori = kategoriService.getListKategori();
        model.addAttribute("listKategori", listKategori);

        List<SubkategoriModel> listSubkategori = subkategoriService.getListSubkategori();
        model.addAttribute("listSubkategori", listSubkategori);

        List<CompanyModel> listCompany = companyService.getListCompanyByStatus(List.of(1, 2));
        model.addAttribute("listCompany", listCompany);

        return "form-add-project";
    }

    @PostMapping(value = "/add")
    public String addProjectSubmit(ProjectModel project) {
        project.setTanggalMulai(LocalDate.now());
        project.setIsFinished(false);

        try {
            projectService.addProject(project);
        } catch (Exception e) {
            return "redirect:/projects/add";
        }

        return "redirect:/projects";
    }

    @GetMapping(value = "/{uuid}")
    public String detailProject(@PathVariable("uuid") Integer uuid, Model model) {
        Optional<ProjectModel> relatedProject = projectService.getProjectByUuid(uuid);

        if (!relatedProject.isPresent()) {
            return "redirect:/projects";
        }

        model.addAttribute("operation", "update");

        List<KategoriModel> listKategori = kategoriService.getListKategori();
        model.addAttribute("listKategori", listKategori);

        List<SubkategoriModel> listSubkategori = subkategoriService.getListSubkategori();
        model.addAttribute("listSubkategori", listSubkategori);

        List<CompanyModel> listCompany = companyService.getListCompanyByStatus(List.of(1, 2));
        model.addAttribute("listCompany", listCompany);

        ProjectModel project = relatedProject.get();

        model.addAttribute("project", project);

        // if (project.getIsFinished()) {
        // return "view-project";
        // }

        return "form-update-project";
    }

    @PostMapping(value = "/{uuid}")
    public String updateProject(@PathVariable("uuid") Integer uuid, ProjectModel project) {
        Optional<ProjectModel> relatedProject = projectService.getProjectByUuid(uuid);

        if (!relatedProject.isPresent()) {
            return "redirect:/projects";
        }

        ProjectModel relatedProjectModel = relatedProject.get();
        relatedProjectModel.setNama(project.getNama());
        relatedProjectModel.setDeskripsi(project.getDeskripsi());
        relatedProjectModel.setKategori(project.getKategori());
        relatedProjectModel.setSubkategori(project.getSubkategori());
        relatedProjectModel.setCompany(project.getCompany());
        relatedProjectModel.setEstimatedProfit(project.getEstimatedProfit());

        projectService.updateProject(relatedProjectModel);

        return "redirect:/projects";
    }

    @PostMapping(value = "/{uuid}:finish")
    public String finishProject(@PathVariable("uuid") Integer uuid) {
        Optional<ProjectModel> relatedProject = projectService.getProjectByUuid(uuid);

        if (!relatedProject.isPresent()) {
            return "redirect:/projects";
        }

        ProjectModel project = relatedProject.get();

        project.setTanggalSelesai(LocalDate.now());
        project.setIsFinished(true);
        projectService.updateProject(project);
        return "redirect:/projects";
    }

}

