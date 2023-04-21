/*여행정보 엔티티*/

package com.oraclejava.tour.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tourinfo")
public class TourInfo {
	
	@Id
	@Column(name="tour_code")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="tour_id_seq")
	@SequenceGenerator(name="tour_id_seq", sequenceName="tour_seq", allocationSize = 1)
	private int tourCode;//pk
	private String tourName;
	private int tourDays;
	private Date depDay;
	private int basePrice;
	private String conductor;
	private String tourAbs;
	//private int accomComde;

	// 다대일관계 
	@JoinColumn(name="accom_code", referencedColumnName="accom_code")
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	private Accommodation accommodation;
	
}
