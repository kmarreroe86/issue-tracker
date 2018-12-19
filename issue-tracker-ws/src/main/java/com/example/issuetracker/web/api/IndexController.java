package com.example.issuetracker.web.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	
	@RequestMapping("/")
	public String getIndex() throws Exception {
		log.debug("Index");
		
		return "dashboard";
	}

}
