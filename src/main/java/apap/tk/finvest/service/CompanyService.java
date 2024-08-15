package apap.tk.finvest.service;

import java.util.List;

import apap.tk.finvest.model.CompanyModel;

public interface CompanyService {
    // Method untuk menambahkan course
    void addCompany(CompanyModel company);

    // Method untuk mendaftarkan daftar course
    List<CompanyModel> getListCompany();

    List<CompanyModel> getListCompanyByStatus(List<Integer> status);

    // Method untuk update course
    CompanyModel updateCompany(CompanyModel company);

    // Method untuk mendapatkan data course berdasarkan code course
    CompanyModel getCompanyByUuid(Integer uuid);
}
