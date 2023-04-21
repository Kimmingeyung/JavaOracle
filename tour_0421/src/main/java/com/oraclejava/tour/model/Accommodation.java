/* 숙박정보 엔티티
 * accommodation 테이블로 맵핑
 * 테이블 어노테이션을 사용해서 명확하게 테이블을 매타정보를 명확히함
 * */
package com.oraclejava.tour.model;

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
@Table(name="accommodation")   
public class Accommodation {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="accom_id_seq")
	@SequenceGenerator(name="accom_id_seq", sequenceName="accom_seq", allocationSize = 1)
	@Column(name="accom_code")  
	private int accomCode;
	private String accomName;
	private String accomTel;
}
