package com.danyprj.service.gcd;


import java.util.List;

import com.danyprj.models.soap.gcd.UnicoParamPojo;




public interface UnicoAdService {
	
	public UnicoParamPojo save(UnicoParamPojo unicoParamPojo);
	
	public List<UnicoParamPojo> list();
	
	public int greatestCommonDivisor(int a, int b);

	
}
