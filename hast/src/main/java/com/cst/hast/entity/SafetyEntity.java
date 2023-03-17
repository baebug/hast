package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "safety")
public class SafetyEntity {

	@Id
	@JoinColumn(name = "world_id")
	private Long worldId;

	@OneToOne
	@MapsId
	@JoinColumn(name = "world_id")
	private WorldEntity worldEntity;

   	@Column(name = "safety1")
	private Long safety1;

   	@Column(name = "safety2")
	private Long safety2;

   	@Column(name = "safety3")
	private Long safety3;

   	@Column(name = "safety4")
	private Long safety4;

   	@Column(name = "safety5")
	private Long safety5;

   	@Column(name = "safety6")
	private Long safety6;

   	@Column(name = "safety7")
	private Long safety7;

   	@Column(name = "safety8")
	private Long safety8;

   	@Column(name = "safety9")
	private Long safety9;

   	@Column(name = "safety10")
	private Long safety10;

   	@Column(name = "safety11")
	private Long safety11;

   	@Column(name = "safety12")
	private Long safety12;


}
