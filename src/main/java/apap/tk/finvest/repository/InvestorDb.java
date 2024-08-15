package apap.tk.finvest.repository;

import apap.tk.finvest.model.InvestorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorDb extends JpaRepository<InvestorModel, Integer> {
    //    jpa
    public boolean existsByNamaInvestor(String namaInvestor);
    public  InvestorModel findByNamaInvestor(String namaInvestor);
}

