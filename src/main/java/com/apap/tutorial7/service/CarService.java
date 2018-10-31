package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.CarModel;

public interface CarService {
	CarModel addCar(CarModel car);
	void updateCar(long id, CarModel car);
	List<CarModel> sortByPrice(Long dealerId);
	Optional<CarModel> getCarDetailById(Long carId);
	List<CarModel> getAllCar();
	void deleteCarById(long carId);
}