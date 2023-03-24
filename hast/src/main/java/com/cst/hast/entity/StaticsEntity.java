package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "statics_table")
public class StaticsEntity {

	@Id
   	@Column(name = "statics_id")
	private Long staticsId;

	@Column(name="statistics_month")
	private Integer statisticsMonth;

	@Column(name = "statistics_country_code")
	private String statisticsCountryCode;

	@Column(name = "statistics_safety")
	private Integer statisticsSafety;


}
