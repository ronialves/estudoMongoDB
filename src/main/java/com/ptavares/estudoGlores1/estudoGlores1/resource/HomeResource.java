package com.ptavares.estudoGlores1.estudoGlores1.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeResource {
	
	@RequestMapping("/")
    public String index() {
        return "index";
    }
	
}
