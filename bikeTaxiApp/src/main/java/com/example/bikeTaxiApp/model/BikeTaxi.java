package com.example.bikeTaxiApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BikeTaxi {
	@Id
	private String email;
	private String password;
	private String username;
	private String gender;
	private String age;
	private String profession;
	private String code;
	private int phone_no;
	private String country;
	private String state;
	private String district;
	private String payment;
	private String offer_code;
	public String getOffer_code() {
		return offer_code;
	}
	public void setOffer_code(String offer_code) {
		this.offer_code = offer_code;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	private String usage_info;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getUsage_info() {
		return usage_info;
	}
	public void setUsage_info(String usage_info) {
		this.usage_info = usage_info;
	}
}
