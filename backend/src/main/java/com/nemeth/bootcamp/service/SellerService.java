package com.nemeth.bootcamp.service;

import com.nemeth.bootcamp.dto.SellerDTO;
import com.nemeth.bootcamp.entities.Seller;
import com.nemeth.bootcamp.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public Page<SellerDTO> findAll(Pageable pageable) {
        Page<Seller> result = repository.findAll(pageable);
        return result.map(SellerDTO::new);
    }
}
