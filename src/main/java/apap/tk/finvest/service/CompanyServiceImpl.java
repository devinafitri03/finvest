package apap.tk.finvest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tk.finvest.model.CompanyModel;
import apap.tk.finvest.repository.CompanyDb;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDb companyDb;

    @Override
    public void addCompany(CompanyModel company) {
        companyDb.save(company);
    }

    @Override
    public List<CompanyModel> getListCompany() {
        return companyDb.findAll();
    }

    @Override
    public List<CompanyModel> getListCompanyByStatus(List<Integer> status) {
        return companyDb.findByStatusPerusahaanIsIn(status);
    }

    @Override
    public CompanyModel updateCompany(CompanyModel company) {
        companyDb.save(company);
        return company;
    }

    @Override
    public CompanyModel getCompanyByUuid(Integer uuid) {
        Optional<CompanyModel> company = companyDb.findById(uuid);
        if (company.isPresent()) {
            return company.get();
        } else
            return null;
    }

}
