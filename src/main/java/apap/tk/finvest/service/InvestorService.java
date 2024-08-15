package apap.tk.finvest.service;

import apap.tk.finvest.model.InvestorModel;

public interface InvestorService {

    void addInvestor(InvestorModel investor);

    boolean doesExistByInvestorName(String investorName);

    InvestorModel getInvestorByInvestorName(String investorName);

}

