package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.repository.CarDb;

@Service
@Transactional
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDb carDb;
	
	@Override
	public CarModel addCar(CarModel car) {
		return carDb.save(car);
	}

	@Override
	public void updateCar(long id, CarModel newCar) {
		// TODO Auto-generated method stub
		CarModel car = carDb.getOne(id);
		car.setBrand(newCar.getBrand());
		car.setType(newCar.getType());
		car.setPrice(newCar.getPrice());
		car.setAmount(newCar.getAmount());
		carDb.save(car);
	}

	@Override
	public List<CarModel> sortByPrice(Long dealerId) {
		return carDb.findByDealerIdOrderByPriceDesc(dealerId);
	}

	@Override
	public List<CarModel> getAllCar() {
		// TODO Auto-generated method stub
		return carDb.findAll();
	}

	@Override
	public void deleteCarById(long carId) {
		// TODO Auto-generated method stub
		carDb.delete(this.getCarDetailById(carId).get());
	}

	@Override
	public Optional<CarModel> getCarDetailById(Long carId) {
		return carDb.findById(carId);
	}
}
