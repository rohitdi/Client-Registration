package com.RealEstate.Repository;

import com.RealEstate.Entitites.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {
}
