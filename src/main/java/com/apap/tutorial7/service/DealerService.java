package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.repository.DealerDb;

public interface DealerService {
	
	DealerModel addDealer(DealerModel dealer);

	void deleteDealer(DealerModel model);

	void updateDealer(long id, DealerModel dealer);

	Optional<DealerModel> getDealerDetailById(Long id);

	List<DealerModel> viewAllDealer();
}

