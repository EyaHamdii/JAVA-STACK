package com.eya.SaveTravels.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.eya.SaveTravels.model.TravelModel;

@Repository

public interface SaveTravelRepo extends CrudRepository<TravelModel, Long> {
	 List<TravelModel> findAll();

}
