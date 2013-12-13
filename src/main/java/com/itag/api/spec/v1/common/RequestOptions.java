package com.itag.api.spec.v1.common;

import java.util.Locale;
import org.springframework.util.Assert;

public class RequestOptions {

	private final String baseUri;
	private final boolean metadata;
	private final RemoteDeviceOptions remoteDeviceOptions;
	private final boolean secure;
	private String userAgent;
	private final Version version;
	private final Locale locale;
	
	public RequestOptions() {
		this.baseUri = "baseUri";
		this.metadata = false;
		this.version = null;
		this.locale = new Locale("en");
        this.remoteDeviceOptions = null; 
        this.userAgent = "userAgent";
		this.secure = false;
	}
	
	public RequestOptions(String baseUri, Version version, Locale locale,
			RemoteDeviceOptions remoteDeviceOptions, String userAgent,
			boolean metadata, boolean secure) {
		Assert.hasLength(baseUri);
		Assert.notNull(version);
		Assert.notNull(locale);
		this.baseUri = baseUri;
		this.metadata = metadata;
		this.version = version;
		this.locale = locale;
        this.remoteDeviceOptions = remoteDeviceOptions; 
        this.userAgent = userAgent;
		this.secure = secure;
	}

	public String getBaseUri() {
		return baseUri;
	}

	public boolean isMetadata() {
		return metadata;
	}

	public RemoteDeviceOptions getRemoteDeviceOptions() {
		return remoteDeviceOptions;
	}

	public boolean isSecure() {
		return secure;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public Version getVersion() {
		return version;
	}

	public Locale getLocale() {
		return locale;
	}

}
