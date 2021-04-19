package com.wipro.BED2.Service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.BED2.Dao.BestChoiceCarsDao;
import com.wipro.BED2.Model.BestChoiceCars;

@Service
public class BestChoiceCarsService {
	@Autowired
	BestChoiceCarsDao repo;
	
	public List<BestChoiceCars> getByBrand(String brand){
		
		List<BestChoiceCars> carsByBrand=(List<BestChoiceCars>) repo.findByBrand(brand);
		
		return carsByBrand;
		
		
	}
	public Set findAllBrands(){
		Set totalbrand=repo.findBrands();
		return totalbrand;
	}
	
	public List<BestChoiceCars> getByPrice(String priceStatus){
		
		List<BestChoiceCars> cars = null;
		
		if(priceStatus.equals("lessthan5"))
			cars=(List<BestChoiceCars>) repo.findByPriceLesser();
		else if(priceStatus.equals("greaterthan5"))
			cars=(List<BestChoiceCars>) repo.findByPriceGreater();
		
		return cars;
		
		
	}

}
