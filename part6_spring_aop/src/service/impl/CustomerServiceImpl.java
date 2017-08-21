package service.impl;

import annocation.RequestPermission;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {


	@RequestPermission("customer:save")
	@Override
	public void saveObject() {
	  // System.out.println("method.start");
       System.out.println("saveObject");
      // System.out.println("method.end");
	}
	@RequestPermission("customer:update")
	@Override
	public void updateObject() {
	  // System.out.println("method.start");
	   System.out.println("updateObject");
	  // System.out.println("method.end");
	}

	@Override
	public void readObject() {
		System.out.println("readobject");
	}


}
