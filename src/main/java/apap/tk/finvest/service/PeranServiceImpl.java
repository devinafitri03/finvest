package apap.tk.finvest.service;

import apap.tk.finvest.model.PeranModel;
import apap.tk.finvest.repository.PeranDb;
import apap.tk.finvest.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeranServiceImpl implements PeranService {

    @Autowired
    private PeranDb peranDb;

    @Override
    public List<PeranModel> findAll() {
        return peranDb.findAll();
    }

    @Override
    public void addPeran(PeranModel peran) {
        peranDb.save(peran);
    }
}
