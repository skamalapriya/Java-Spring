package com.code.entity;

import com.code.service.FortuneService;

public class Cricket implements Coach{
	FortuneService fortuneService;
	
	/*public Cricket() {
		
	}*/
	
	public Cricket(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice batting for 1 hour";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}



}
