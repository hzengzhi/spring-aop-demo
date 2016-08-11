package com.wgmf.temporyjob.aop;

import org.springframework.stereotype.Component;

@Component
public class AopService {
	@Log("aopService")
	public String  doService(String s){
		return s;
	}
}
