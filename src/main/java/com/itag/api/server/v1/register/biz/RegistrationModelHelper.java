package com.itag.api.server.v1.register.biz;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class RegistrationModelHelper {

	public static <T> T mapper(Object srcObj, Class<T> desClass) {
		Mapper mapper = new DozerBeanMapper();
		    return mapper.map(srcObj, desClass);
	}
	
}
