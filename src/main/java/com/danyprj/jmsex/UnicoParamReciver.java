package com.danyprj.jmsex;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.danyprj.endpoints.GcdEndpoint;
import com.danyprj.models.soap.gcd.UnicoParamPojo;
import com.danyprj.service.gcd.UnicoAdService;

@Component
public class UnicoParamReciver {
	
	@Autowired
	private UnicoAdService unicoService;
	
	@JmsListener(destination = "unicoparams", containerFactory = "myFactory")
	public void receiveMessage(UnicoParamPojo unicoParamPojo) throws IOException {
	
		unicoParamPojo.setSumNumber(unicoParamPojo.getFirstNumber() + unicoParamPojo.getSecondNumber());
		unicoParamPojo.setGcdNumber(unicoService.greatestCommonDivisor(unicoParamPojo.getFirstNumber(),unicoParamPojo.getSecondNumber()));
		unicoService.save(unicoParamPojo);
		GcdEndpoint.setUnicoParamPojo(unicoParamPojo);
		System.out.println("Que Received --- > "+unicoParamPojo.toString());
	}
	
	 
  
	

}
