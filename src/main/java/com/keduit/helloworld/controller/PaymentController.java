package com.keduit.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaymentController {
	
	@GetMapping("/payment")
	public String payment() {
		return "payment";
	}

	
}
