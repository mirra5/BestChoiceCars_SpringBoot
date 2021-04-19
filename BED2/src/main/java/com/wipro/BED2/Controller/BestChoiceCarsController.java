package com.wipro.BED2.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.BED2.Model.BestChoiceCars;
import com.wipro.BED2.Service.BestChoiceCarsService;

@Controller
@RequestMapping("/")
public class BestChoiceCarsController {
	@Autowired
	BestChoiceCarsService service;
	
	@RequestMapping(path="/")
	public String index() {
		return "Home";
	}
	@RequestMapping(path="/carsByPrice")
    public String carsByPrice()
    {
		System.out.println("in method");
		
        return "carsByPrice";
    }
	@RequestMapping(path="/carsByBrand")
    public String carsByBrand(Model model)
    {
		System.out.println("in method");
		Set allbrand=service.findAllBrands();
		System.out.println(allbrand.size()); 
		model.addAttribute("allbrand", allbrand);
        return "carsByBrand";
    }
	@RequestMapping(path="/carByBrand", method=RequestMethod.POST)
	public String getByBrand(Model model,String brand) {
		System.out.println("brand is "+brand);  
		List<BestChoiceCars> cars=service.getByBrand(brand);
		System.out.println("Size is : "+cars.size()+" brand selected is "+brand);
		model.addAttribute("bestchoicecars", cars);
		model.addAttribute("prev", "carsByBrand");
		return "CarDetails";
		 
	}
	@RequestMapping(path="/carByPrice", method=RequestMethod.POST)
	public String getByPrice(Model model,String lessorgreater) {
		System.out.println("price selected is : "+lessorgreater);
		List<BestChoiceCars> cars=service.getByPrice(lessorgreater);
		System.out.println("Size is : "+cars.size()); 
		model.addAttribute("bestchoicecars", cars);
		model.addAttribute("prev", "carsByPrice");
		return "CarDetails";
	}
	@RequestMapping(path="/Success", method=RequestMethod.POST)
	public String bookingSuccess(String selectedCar,Model model) {
		System.out.println("Car selected is  : "+selectedCar);
		model.addAttribute("selectedCar", selectedCar);
		return "Success";
	} 

}
