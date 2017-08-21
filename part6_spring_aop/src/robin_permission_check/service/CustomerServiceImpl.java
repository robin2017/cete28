package robin_permission_check.service;

import robin_permission_check.aspect.RequestPermission;

public class CustomerServiceImpl implements CustomerService {
	@RequestPermission("save")
	@Override
	public void saveObject() {
       System.out.println("saveObject");
	}

	@RequestPermission("update")
	@Override
	public void updateObject() {
	   System.out.println("updateObject");
	}

	@Override
	public void readObject() {
		System.out.println("readobject");
	}


}
