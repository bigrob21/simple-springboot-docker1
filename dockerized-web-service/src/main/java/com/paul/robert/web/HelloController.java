package com.paul.robert.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private Environment env;
	
	@RequestMapping(method={RequestMethod.GET}, produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> getAMessage(){
		final String NADA = "-- NADA --";
		String message = "param1 = " + env.getProperty("app.param1", NADA) + " " + 
				"param2 = " + env.getProperty("app.param2", NADA);
		return ResponseEntity.ok(message);
	}
	
}
