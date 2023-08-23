package com.eya.SaveTravels.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.eya.SaveTravels.model.TravelModel;

import com.eya.SaveTravels.Repositories.SaveTravelRepo;

@Service
public class TravelService {
		private final SaveTravelRepo TravelRepo;
		
		public TravelService(SaveTravelRepo TravelRepo) {
			this.TravelRepo = TravelRepo;
		}
		
		public List<TravelModel> allTravel() {
			return TravelRepo.findAll();
		}
		
		public TravelModel addTravel(TravelModel travel) {
			return TravelRepo.save(travel);
		}

	    public TravelModel findTravel(Long id) {
	         
			Optional<TravelModel> maybeTravel = TravelRepo.findById(id);
			if(maybeTravel.isPresent()) {
				return maybeTravel.get();
			}else {
				return null;
			} 
	    }
	    public TravelModel updateTravel(TravelModel travel) {

	        return TravelRepo.save(travel);
	    }
		
		// DELETE
		public void deleteTravel(Long id) {
			TravelRepo.deleteById(id);
		}
}