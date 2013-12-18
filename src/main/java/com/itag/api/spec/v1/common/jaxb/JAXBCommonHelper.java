package com.itag.api.spec.v1.common.jaxb;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.util.Assert;

public final class JAXBCommonHelper {
	
	private JAXBCommonHelper() {}
	
	private static final Map<String,JAXBContext> marshalMap = 
		new ConcurrentHashMap<String,JAXBContext>();

	public static <T> T unmarshal(Class<T> docClass, InputStream input) 
	throws JAXBException {
		Assert.notNull(docClass);
		Assert.notNull(input);
		return unmarshalInternal(docClass, input, null);
	}

	public static <T> T unmarshal(Class<T> docClass, Reader reader) 
	throws JAXBException {
		Assert.notNull(docClass);
		Assert.notNull(reader);
		return unmarshalInternal(docClass, null, reader);
	}
	
	@SuppressWarnings("unchecked")
	private static <T> T unmarshalInternal(Class<T> docClass, InputStream input, Reader reader) 
	throws JAXBException {
		assert docClass != null;
		String packageName = docClass.getPackage().getName();
		JAXBContext jc = marshalMap.get(packageName);
		if(jc == null) {
			jc = JAXBContext.newInstance(packageName);
			marshalMap.put(packageName, jc);
		}
		Unmarshaller u = jc.createUnmarshaller();
		JAXBElement jaxbElement = input != null ? (JAXBElement)u.unmarshal(input) :
			(JAXBElement)u.unmarshal(reader);
		return (T)jaxbElement.getValue();
	}

	public static void marshal(Object jaxbElement, Class<?> docClass, OutputStream output) 
	throws JAXBException {
		Assert.notNull(jaxbElement);
		Assert.notNull(docClass);
		Assert.notNull(output);
		marshalInternal(jaxbElement, docClass, output, null);
	}
	
	public static void marshal(Object jaxbElement, Class<?> docClass, Writer writer) 
	throws JAXBException {
		Assert.notNull(jaxbElement);
		Assert.notNull(docClass);
		Assert.notNull(writer);
		marshalInternal(jaxbElement, docClass, null, writer);
	}
	
	private static void marshalInternal(Object jaxbElement, Class<?> docClass, OutputStream output, Writer writer) 
	throws JAXBException {
		assert jaxbElement != null;
		assert docClass != null;
		assert output != null || writer != null; 
		Marshaller m = createMarshaller(jaxbElement, docClass);
		if(output != null) {
			m.marshal(jaxbElement, output);
		} else {
			m.marshal(jaxbElement, writer);
		}
	}

	public static Marshaller createMarshaller(Object jaxbElement, Class<?> docClass) 
	throws JAXBException {
		Assert.notNull(jaxbElement);
		Assert.notNull(docClass);
		String packageName = docClass.getPackage().getName();
		JAXBContext jc = marshalMap.get(packageName);
		if(jc == null) {
			jc = JAXBContext.newInstance(packageName);
			marshalMap.put(packageName, jc);
		}
		return jc.createMarshaller();
	}
	
}
