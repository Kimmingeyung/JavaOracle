package com.oraclejava;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int customerCode;
	private String customerName;
	private String customerPass;
	private Date customerBirth;
	private String customerJob;
	private String customerMail;
	private String customerTel;
	private String customerPost;
	private String customerAdd;
	
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPass() {
		return customerPass;
	}
	public void setCustomerPass(String customerPass) {
		this.customerPass = customerPass;
	}
	public Date getCustomerBirth() {
		return customerBirth;
	}
	public void setCustomerBirth(Date customerBirth) {
		this.customerBirth = customerBirth;
	}
	public String getCustomerJob() {
		return customerJob;
	}
	public void setCustomerJob(String customerJob) {
		this.customerJob = customerJob;
	}
	public String getCustomerMail() {
		return customerMail;
	}
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerPost() {
		return customerPost;
	}
	public void setCustomerPost(String customerPost) {
		this.customerPost = customerPost;
	}
	public String getCustomerAdd() {
		return customerAdd;
	}
	public void setCustomerAdd(String customerAdd) {
		this.customerAdd = customerAdd;
	}
	

}
