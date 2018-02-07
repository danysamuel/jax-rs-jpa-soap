package com.danyprj.rest.gcd;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danyprj.models.soap.gcd.UnicoParamPojo;
import com.danyprj.service.gcd.UnicoAdService;

@RestController
public class UnicoAdRestController {

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private UnicoAdService unicoService;
	
	@RequestMapping("/push/{i1}/{i2}")
	public String push(@PathVariable("i1") Integer i1, @PathVariable("i2") Integer i2) {

		UnicoParamPojo uni = new UnicoParamPojo();
		uni.setFirstNumber(i1);
		uni.setSecondNumber(i2);
		JmsTemplate jmsTemplate = appContext.getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("unicoparams", uni);

		return "Added to Que";
	}
	
	@RequestMapping("/list")
	public List<Integer> list(){
		List<Integer> iList = new ArrayList<Integer>();

		for(UnicoParamPojo u : unicoService.list()) {
			iList.add(u.getFirstNumber());
			iList.add(u.getSecondNumber());
		}
		return iList;
		
	}

}
