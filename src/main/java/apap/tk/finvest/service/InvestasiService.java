package apap.tk.finvest.service;

import apap.tk.finvest.model.InvestasiModel;
import apap.tk.finvest.model.InvestorModel;

import java.util.List;

public interface InvestasiService {

void addInvestasi(InvestasiModel investasi);

List<InvestasiModel> getInvestasiByInvestor(InvestorModel investorModel);

}
