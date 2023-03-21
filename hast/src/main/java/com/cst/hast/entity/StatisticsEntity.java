package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "statistics")
public class StatisticsEntity {

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
