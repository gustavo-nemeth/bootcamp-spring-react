package com.nemeth.bootcamp.repositories;

import com.nemeth.bootcamp.dto.SaleSuccessDTO;
import com.nemeth.bootcamp.dto.SaleSumDTO;
import com.nemeth.bootcamp.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.nemeth.bootcamp.dto.SaleSumDTO(obj.seller, sum(obj.amount)) " +
            "FROM Sale as obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.nemeth.bootcamp.dto.SaleSuccessDTO(obj.seller, sum(obj.visited), sum(obj.deals)) " +
            "FROM Sale as obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}
