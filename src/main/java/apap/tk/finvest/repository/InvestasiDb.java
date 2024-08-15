package apap.tk.finvest.repository;

import apap.tk.finvest.model.InvestasiModel;
import apap.tk.finvest.model.InvestorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestasiDb extends JpaRepository<InvestasiModel, Integer> {
    //    jpa
    List<InvestasiModel> getByIdInvestor(InvestorModel investorModel);
}
