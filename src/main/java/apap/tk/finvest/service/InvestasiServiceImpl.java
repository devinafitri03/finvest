package apap.tk.finvest.service;

import apap.tk.finvest.model.InvestasiModel;
import apap.tk.finvest.model.InvestorModel;
import apap.tk.finvest.repository.InvestasiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestasiServiceImpl implements InvestasiService {

    @Autowired
    InvestasiDb investasiDb;

    public void addInvestasi(InvestasiModel investasi){investasiDb.save(investasi);}

    public List<InvestasiModel> getInvestasiByInvestor(InvestorModel investorModel){return investasiDb.getByIdInvestor(investorModel);}

}
