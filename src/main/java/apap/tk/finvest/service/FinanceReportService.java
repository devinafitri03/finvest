package apap.tk.finvest.service;

import apap.tk.finvest.model.FinanceReportModel;
import java.util.List;

public interface FinanceReportService {

    void addItem(FinanceReportModel financeReportModel);

    void updateItem(FinanceReportModel financeReportModel);

    FinanceReportModel deleteItem(FinanceReportModel financeReportModel);

    Integer getNetProfit(FinanceReportModel financeReportModel);

    List<FinanceReportModel> getListFinanceReport();

    FinanceReportModel getProyekById(Integer proyekId);
}
