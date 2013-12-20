package com.itag.api.server.v1.common;

import org.springframework.util.Assert;

public enum Version {
	
	// Note: must be listed in increasing order.
	
	v1_0((byte)1,(byte)0), // "1.0"
	v1_1((byte)1,(byte)1), // "1.1"
	v1_2((byte)1,(byte)2), // "1.2"
	v1_3((byte)1,(byte)3), // "1.3"
	v1_4((byte)1,(byte)4), // "1.4"
	v1_5((byte)1,(byte)5), // "1.5"
	v1_6((byte)1,(byte)6), // "1.6"
	v1_7((byte)1,(byte)7), // "1.7"
	v1_8((byte)1,(byte)8), // "1.8"
	v1_9((byte)1,(byte)9), // "1.9"
	v1_10((byte)1, (byte)10), // "1.10"
	v1_11((byte)1, (byte)11), // "1.11"
	v1_12((byte)1, (byte)12), // "1.12"
	v1_13((byte)1, (byte)13), // "1.13"
	v1_14((byte)1, (byte)14), // "1.14"
	v1_15((byte)1, (byte)15), // "1.15"
	v1_16((byte)1, (byte)16); // "1.16"

	private final byte major;
	private final byte minor;
	
	private static final String SEP = ".";
	private static final String SPLIT_SEP = "\\" + SEP;
	
	private Version(byte major, byte minor) {
		this.major = major;
		this.minor = minor;
	}

	public byte getMajor() {
		return major;
	}

	public byte getMinor() {
		return minor;
	}
	
	public static Version getLatestVersion() {
		return Version.values()[Version.values().length - 1];
	}

	public static Version fromString(String value) {
		Assert.hasLength(value);
		String[] numbers = value.split(SPLIT_SEP);
		Assert.isTrue(numbers.length == 2, "Cannot split version string to major and minor numbers");
		byte major = Byte.parseByte(numbers[0]);
		byte minor = Byte.parseByte(numbers[1]);
		Version[] versions = Version.values();
		for(Version version : versions) {
			if(version.major == major && version.minor == minor) {
				return version;
			}
		}
		return null;
	}
	
	public boolean greaterThan(Version v) {
		return v != null && ordinal() > v.ordinal();
	}
	
	public boolean greaterThanOrEqual(Version v) {
		return v != null && ordinal() >= v.ordinal();
	}
	
	public boolean lessThan(Version v) {
		return v != null && ordinal() < v.ordinal();
	}
	
	public boolean lessThanOrEqual(Version v) {
		return v != null && ordinal() <= v.ordinal();
	}
	
	@Override
	public String toString() {
		return Byte.toString(major) + SEP + Byte.toString(minor);
	}
	
}
