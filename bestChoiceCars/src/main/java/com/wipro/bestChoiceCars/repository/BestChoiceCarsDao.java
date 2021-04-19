package com.wipro.bestChoiceCars.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bestChoiceCars.model.BestChoiceCars;

@Repository
public interface BestChoiceCarsDao extends CrudRepository<BestChoiceCars, Long>{

	@Query(value ="SELECT * FROM BestChoiceCars c WHERE c.brand= ?1",nativeQuery = true)
	public List<BestChoiceCars> findByBrand(String brand);
	
	@Query(value ="SELECT * FROM BestChoiceCars c WHERE c.price < 500000",nativeQuery = true)
	public List<BestChoiceCars> findByPriceLesser();
	@Query(value ="SELECT * FROM BestChoiceCars c WHERE c.price > 500000",nativeQuery = true)
	public List<BestChoiceCars> findByPriceGreater();
	@Query(value ="SELECT c.brand FROM BestChoiceCars c",nativeQuery = true)
	public Set findBrands();
}
