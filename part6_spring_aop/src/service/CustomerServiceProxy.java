package service;

import common.LogAspect;

public class CustomerServiceProxy implements CustomerService{
    private CustomerService customerService;
    public CustomerServiceProxy(CustomerService customerService) {
    	this.customerService=customerService;
	}
    private LogAspect logAspect;
    public void setLogAspect(LogAspect logAspect) {
		this.logAspect = logAspect;
	}
	@Override
	public void saveObject() {
		//System.out.println("method.start");
		this.logAspect.before();
		this.customerService.saveObject();
		this.logAspect.afterReturn();
		//System.out.println("method.end");
	}
	@Override
	public void updateObject() {
		//System.out.println("method.start");
		this.logAspect.before();
		this.customerService.updateObject();
		this.logAspect.afterReturn();
		//System.out.println("method.end");
	}

	@Override
	public void readObject() {
		this.logAspect.before();
		this.customerService.updateObject();
		this.logAspect.afterReturn();
	}
}
