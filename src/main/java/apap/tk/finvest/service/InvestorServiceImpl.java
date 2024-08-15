package apap.tk.finvest.service;

import apap.tk.finvest.model.InvestorModel;
import apap.tk.finvest.repository.InvestorDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestorServiceImpl implements InvestorService {
    @Autowired
    InvestorDb investorDb;

    @Override
    public void addInvestor(InvestorModel investor){investorDb.save(investor);}

//    use if empty to check returns
    @Override
    public boolean doesExistByInvestorName(String investorName){return investorDb.existsByNamaInvestor(investorName);}

    @Override
    public InvestorModel getInvestorByInvestorName(String investorName){return investorDb.findByNamaInvestor(investorName);}

}
