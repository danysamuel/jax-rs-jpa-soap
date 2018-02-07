package com.danyprj.endpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.danyprj.models.soap.gcd.GetGcdListRequest;
import com.danyprj.models.soap.gcd.GetGcdListResponse;
import com.danyprj.models.soap.gcd.GetGcdRequest;
import com.danyprj.models.soap.gcd.GetGcdResponse;
import com.danyprj.models.soap.gcd.GetGcdSumRequest;
import com.danyprj.models.soap.gcd.GetGcdSumResponse;
import com.danyprj.models.soap.gcd.UnicoParamPojo;
import com.danyprj.service.gcd.UnicoAdService;

@Endpoint
public class GcdEndpoint {
	private static final String NAMESPACE_URI = "http://danyprj.com/models/soap/gcd";

	private static UnicoParamPojo unicoParamPojo;
	
	public static UnicoParamPojo getUnicoParamPojo() {
		return unicoParamPojo;
	}

	public static void setUnicoParamPojo(UnicoParamPojo unicoParamPojo) {
		GcdEndpoint.unicoParamPojo = unicoParamPojo;
	}



	@Autowired
	private UnicoAdService unicoAdService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGcdRequest")
	@ResponsePayload
	public GetGcdResponse gcd(@RequestPayload GetGcdRequest request) {
		GetGcdResponse response = new GetGcdResponse();
		response.setGcdno(unicoParamPojo.getGcdNumber());

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGcdSumRequest")
	@ResponsePayload
	public GetGcdSumResponse gcdSum(@RequestPayload GetGcdSumRequest request) {
		GetGcdSumResponse response = new GetGcdSumResponse();

		List<Integer> intList = new ArrayList<Integer>();

		for (UnicoParamPojo u : unicoAdService.list())
			intList.add(u.getGcdNumber());

		LongAdder a = new LongAdder();
		intList.parallelStream().forEach(a::add);

		response.setGcdno(a.intValue());

		return response;
	}
	
	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGcdListRequest")
	@ResponsePayload
	public GetGcdListResponse gcdList(@RequestPayload GetGcdListRequest request) {
		GetGcdListResponse response = new GetGcdListResponse();

		String gcdStr="";

		for (UnicoParamPojo u : unicoAdService.list())
			gcdStr=gcdStr + " / " + u.getGcdNumber();

		response.setGcdlist(gcdStr);

		return response;
	}

}
