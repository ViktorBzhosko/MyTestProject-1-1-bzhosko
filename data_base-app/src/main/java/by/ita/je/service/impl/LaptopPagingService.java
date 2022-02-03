package by.ita.je.service.impl;

import by.ita.je.dao.LaptopDaoPag;
import by.ita.je.model.Laptop;
import by.ita.je.service.IServicePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaptopPagingService implements IServicePaging {

    private final LaptopDaoPag laptopDaoPag;

    @Autowired
    public LaptopPagingService(LaptopDaoPag laptopDaoPag) {
        this.laptopDaoPag = laptopDaoPag;
    }

    @Override
    public List<Laptop> getAllLaptops(Pageable pageable) {

        Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());

        Page<Laptop> pagedResult = laptopDaoPag.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
