package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "export")
public class ExportEntity {

	@Id
   	@Column(name = "export_id")
	private Long exportId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "world_id")
	private WorldEntity worldEntity;


	@Column(name = "export_date")
	private LocalDateTime exportDate;

   	@Column(name = "export_cameo")
	private String exportCameo;

   	@Column(name = "export_class")
	private Integer exportClass;

   	@Column(name = "export_gold")
	private BigDecimal exportGold;

   	@Column(name = "event_ton")
	private BigDecimal eventTon;

   	@Column(name = "export_latitude")
	private BigDecimal exportLatitude;

   	@Column(name = "export_longtitude")
	private BigDecimal exportLongtitude;

   	@Column(name = "export_url")
	private String exportUrl;


}
