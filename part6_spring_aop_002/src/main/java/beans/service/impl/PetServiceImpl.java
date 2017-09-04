package beans.service.impl;

import org.springframework.stereotype.Service;

import beans.common.Permission;
import beans.service.PetService;
@Service
public class PetServiceImpl implements PetService{
	public void saveObject() {
		//.....
		System.out.println("save.pet");
		//throw new RuntimeException("≥ˆ“Ï≥£¡À");
		//.....
	}
	@Permission("pet:update")
	public void updateObject() {
		System.out.println("update.pet");
	}
}
