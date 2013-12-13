package com.itag.api.spec.v1.common;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

public class RemoteDeviceOptions {

	/** client's IP address */
	private final String remoteIP;
	/**
	 * unique device identifier if applicable (mobile devices identifier), can
	 * be null
	 */
	private final String udid;
	/** make all HTTP headers available for read-only by implementation */
	private final Map<String, List<String>> headerMap;

	public RemoteDeviceOptions(String remoteIP, String udid,
			Map<String, List<String>> headerMap) {
		Assert.notNull(remoteIP, "remoteIP cannot not be null");
		Assert.notNull(headerMap, "HTTP request header map cannot be null");
		this.remoteIP = remoteIP;
		this.udid = udid;
		this.headerMap = Collections.unmodifiableMap(headerMap);
	}
	
	public String getRemoteIP() {
		return remoteIP;
	}

	public String getUdid() {
		return udid;
	}

	/**
	 * Returns unmodifiable (read-only) map of request HTTP headers.
	 * @return Unmodifiable (read-only) map of request HTTP headers, cannot be null.
	 */
	public Map<String, List<String>> getHeaderMap() {
		return headerMap;
	}
	

	/**
	 * Returns list of values for given header name.
	 * @param headerName Header Name
	 * @return List of values, empty list (if header has no associated values) or null if there is no such header in the map.
	 */
	public List<String> getHeaders(String headerName) {
		return headerMap.get(headerName);
	}

	/**
	 * Returns single header value for given header name.
	 * @param headerName Name of header.
	 * @return Header value (first in the list if there is more than one value) or null if no such header exists. 
	 */
	public String getHeader(String headerName) {
		List<String> headerValues = getHeaders(headerName);
		return headerValues != null ? (headerValues.size() > 0 ? headerValues.get(0) : null) : null;
	}

	/**
	 * Checks if given header present.
	 * @param headerName Name of header.
	 * @return true if such header exists, false otherwise.
	 */
	public boolean containsHeader(String headerName) {
		return headerMap.containsKey(headerName);
	}
	
}