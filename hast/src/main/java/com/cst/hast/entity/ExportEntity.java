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

	@Column(name="world_id")
	private Long worldId;

	@Column(name = "export_date")
	private LocalDateTime exportDate;

	@Column(name = "export_cameo3")
	private String exportCameo3;

	@Column(name = "export_cameo2")
	private String exportCameo2;

	@Column(name = "export_cameo1")
	private String exportCameo1;

	@Column(name = "export_quad")
	private String exportQuad;

	@Column(name = "export_gold")
	private String exportGold;

	@Column(name = "export_tone")
	private String exportTone;

	@Column(name = "export_country")
	private String exportCountry;

   	@Column(name = "export_lat")
	private String exportLat;

   	@Column(name = "export_long")
	private Integer exportLong;

   	@Column(name = "export_time")
	private BigDecimal exportTime;

   	@Column(name = "export_url")
	private BigDecimal exportUrl;

}
