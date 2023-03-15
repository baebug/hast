package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Entity
@Getter
@DynamicInsert // Apply changed fields only
@DynamicUpdate // Apply changed fields only
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "event")
public class EventEntity {

	@Id
   	@Column(name = "event_id")
	private Long eventId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "world_id")
	private WorldEntity worldEntity;

   	@Column(name = "event_code")
	private String eventCode;

   	@Column(name = "event_class")
	private Integer eventClass;

   	@Column(name = "event_gold")
	private BigDecimal eventGold;

   	@Column(name = "event_ton")
	private BigDecimal eventTon;

   	@Column(name = "event_url")
	private String eventUrl;

   	@Column(name = "event_latitude")
	private BigDecimal eventLatitude;

   	@Column(name = "event_longtitude")
	private BigDecimal eventLongtitude;


}
