package com.apap.tutorial7.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.repository.DealerDb;
import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.rest.DealerDetail;
import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.CarService;
import com.apap.tutorial7.service.DealerService;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarService carService;
	
	@Autowired
	private DealerService dealerService;
	
	/**
	 * Latihan 1: POST add car {url}/car
	 * request body: new CarModel
	 * response : new CarModel
	 */
	@PostMapping()
	private CarModel addCarSubmit(@RequestBody CarModel car) {
		return carService.addCar(car);
	}
	
	/**
	 * Latihan 1: GET car {url}/car/{carId}
	 * response : CarModel
	 */
	@GetMapping(value = "/{carId}")
	private CarModel viewCar(@PathVariable ("carId") long carId, Model model) {
		return carService.getCarDetailById(carId).get();
	}
	
	/**
	 * Latihan 1: GET all car {url}/car
	 * response : List<CarModel>
	 */
	@GetMapping()
	private List<CarModel> viewAllCar(Model model){
		return carService.getAllCar();
	}
	
	/**
	 * Latihan 1: Delete car {url}/car/{carId}
	 * response: “car has been deleted”
	 */
	@DeleteMapping(value = "/{carId}")
	private String deleteCar(@PathVariable ("carId") long carId, Model model ) {
		carService.deleteCarById(carId);
		return "Car Has Been Deleted";
	}
	
	/**
	 * Latihan 1: PUT update car
	 * {url}/car/{carID}?brand={brand}&type={type}&price={price}&amount={amount}&dealerID={dealerID}
	 */
	@PutMapping(value = "/{carId}")
	private String updateCarSubmit(
			@PathVariable (value = "id", required=false) long id,
			@RequestParam(value="brand", required=false) Optional<String> brand,
			@RequestParam(value="type", required=false) Optional<String> type,
			@RequestParam(value="price", required=false) Optional<Long> price,
			@RequestParam(value="amount", required=false) Optional<Integer> amount,
			@RequestParam(value="dealerId", required=false) Optional<Long> dealerId) {
		CarModel car = (CarModel) carService.getCarDetailById(id).get();
		carService.updateCar(id, car);
		return "Car Update Success";
		
	}

}
