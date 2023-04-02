package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "statistics_table")
public class StatisticsEntity {

	@Id
   	@Column(name = "statistics_id")
	private Long statisticsId;

	@Column(name="statistics_year")
	private String statisticsYear;

	@Column(name="statistics_month")
	private String statisticsMonth;

	@Column(name = "statistics_country_code")
	private String statisticsCountryCode;

	@Column(name = "statistics_gkg_tone")
	private float statisticsGkgTone;

	@Column(name = "statistics_row_count")
	private Integer statisticsRowCount;

	@Column(name = "statistics_etc_count")
	private Integer statisticsEtcCount;

	@Column(name = "statistics_crime_count")
	private Integer statisticsCrimeCount;

	@Column(name = "statistics_accident_count")
	private Integer statisticsAccidentCount;

	@Column(name = "statistics_disease_count")
	private Integer statisticsDiseaseCount;

	@Column(name = "statistics_disaster_count")
	private Integer statisticsDisasterCount;

	@Column(name = "statistics_politic_count")
	private Integer statisticsPoliticCount;

}
