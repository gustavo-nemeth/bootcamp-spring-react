package com.nemeth.bootcamp.service;

import com.nemeth.bootcamp.dto.SaleDTO;
import com.nemeth.bootcamp.dto.SaleSuccessDTO;
import com.nemeth.bootcamp.dto.SaleSumDTO;
import com.nemeth.bootcamp.entities.Sale;
import com.nemeth.bootcamp.repositories.SaleRepository;
import com.nemeth.bootcamp.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);
        return result.map(SaleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller(){
        return repository.amountGroupedBySeller();

    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller(){
        return repository.successGroupedBySeller();

    }
}
