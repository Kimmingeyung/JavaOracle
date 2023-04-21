package com.oraclejava.tour.repository;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourInfoCriteria {
	
	private String tourName;
	private String tourDays;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date depStartDay;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date depEndDay;
	private Date depDay;
	
	private Integer baseStartPrice;	 // Integer와 int가 다른것은 Integer는 null값으로 채워짐
	private Integer baseEndPrice;
	private String conductor;
	private String tourAbs;
	
	
}
