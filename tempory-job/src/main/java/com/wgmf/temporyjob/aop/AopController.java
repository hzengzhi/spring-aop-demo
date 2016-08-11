package com.wgmf.temporyjob.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="aopController")
public class AopController {
	
	@Autowired
	AopService aopService;
	public AopService getAopService() {
		return aopService;
	}

	public void setAopService(AopService aopService) {
		this.aopService = aopService;
	}

	
	
	public String domywork(String s){
		return aopService.doService(s);
	}
}
