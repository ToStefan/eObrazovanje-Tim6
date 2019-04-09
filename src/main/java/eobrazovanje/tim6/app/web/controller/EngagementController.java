package eobrazovanje.tim6.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import eobrazovanje.tim6.app.service.impl.EngagementService;

@RestController
@RequestMapping(value = "api/engagements")
public class EngagementController {
	
	@Autowired
	private EngagementService engagementService;
	
}
