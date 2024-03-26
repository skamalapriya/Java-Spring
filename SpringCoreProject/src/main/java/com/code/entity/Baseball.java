package com.code.entity;

import com.code.service.FortuneService;

public class Baseball implements Coach{

	FortuneService fortuneService;
	
	/*public Baseball() {
		
	}*/
	
	public Baseball(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
		return "Practice catch for 1 hour";
		
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}
	
	



}
