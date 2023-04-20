package com.oraclejava.tour.repository;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourInfoCriteria {
	private String tourName;
	private int tourDays;
	private Date depDay;
	private int basePrice;
	private String conductor;
	private String tourAbs;
}
