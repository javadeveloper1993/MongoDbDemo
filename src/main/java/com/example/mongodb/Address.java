package com.example.mongodb;

/**
 * @author Maulik
 * 
 */
public class Address {
	private String postalAddress;
	private String city;
	private String country;
	private String pinCode;

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [postalAddress=" + postalAddress + ", city=" + city
				+ ", country=" + country + ", pinCode=" + pinCode + "]";
	}

}
