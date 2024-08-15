package apap.tk.finvest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tk.finvest.model.CompanyModel;
import apap.tk.finvest.model.UserModel;

@Repository
public interface CompanyDb extends JpaRepository<CompanyModel, Integer> {
    List<CompanyModel> findAll();
    List<CompanyModel> findByStatusPerusahaanIsIn(List<Integer> status);
}
