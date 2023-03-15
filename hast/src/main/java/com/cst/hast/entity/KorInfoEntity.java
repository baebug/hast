package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "kor_info")
public class KorInfoEntity {

	@Id
   	@Column(name = "world_id")
	private Long worldId;

   	@Column(name = "info_name")
	private String infoName;

   	@Column(name = "info_capital")
	private String infoCapital;

   	@Column(name = "info_money")
	private String infoMoney;

   	@Column(name = "info_size")
	private String infoSize;

   	@Column(name = "info_popul")
	private Integer infoPopul;


}
