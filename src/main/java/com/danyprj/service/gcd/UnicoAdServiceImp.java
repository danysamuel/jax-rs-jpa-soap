package com.danyprj.service.gcd;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danyprj.models.soap.gcd.UnicoParamPojo;
import com.danyprj.repository.gcd.UnicoAdRepositiory;

@Service
public class UnicoAdServiceImp implements UnicoAdService {

	@Autowired
	private UnicoAdRepositiory unicoAdRepositiory;

	public UnicoParamPojo save(UnicoParamPojo unicoParamPojo) {

		return unicoAdRepositiory.save(unicoParamPojo);

	}

	public List<UnicoParamPojo> list() {

		return (List<UnicoParamPojo>) unicoAdRepositiory.findAll();
	}

	public int greatestCommonDivisor(int a, int b) {
	  	   if (b==0) return a;
	  	   return greatestCommonDivisor(b,a%b);
	  	}
	
}
