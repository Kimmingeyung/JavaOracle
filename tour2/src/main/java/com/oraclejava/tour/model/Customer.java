package com.oraclejava.tour.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "customer_code")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_code_seq")
	@SequenceGenerator(name = "customer_code_seq", sequenceName = "customer_seq", allocationSize = 1)
	private int customerCode;
	private String customerName;
	private String customerPass;
	private Date customerBirth;
	private String customerJob;
	private String customerMail;
	private String customerTel;
	private String customerPost;
	private String customerAdd;
	private String role;
}
