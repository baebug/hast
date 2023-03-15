package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "world")
public class WorldEntity {

	@Id
   	@Column(name = "world_id")
	private Long worldId;

   	@Column(name = "world_kor_name")
	private String worldKorName;

   	@Column(name = "world_eng_name")
	private String worldEngName;

   	@Column(name = "world_alpha2")
	private String worldAlpha2;

   	@Column(name = "world_alpha3")
	private String worldAlpha3;

   	@Column(name = "world_latitude")
	private BigDecimal worldLatitude;

   	@Column(name = "world_longtitude")
	private BigDecimal worldLongtitude;

}
