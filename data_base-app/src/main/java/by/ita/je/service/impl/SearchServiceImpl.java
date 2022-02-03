package by.ita.je.service.impl;

import by.ita.je.dao.SearchJPQLDao;
import by.ita.je.model.Laptop;
import by.ita.je.service.IServiceSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements IServiceSearch {

    private final SearchJPQLDao searchJPQLDao;

    @Autowired
    public SearchServiceImpl(SearchJPQLDao searchJPQLDao) {
        this.searchJPQLDao = searchJPQLDao;
    }

    @Override
    public List<Laptop> findByJPQL(String laptopName, String nameOfCompanyManufacturer) {
        return searchJPQLDao.findByJPQL(laptopName, nameOfCompanyManufacturer);
    }
}
