package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "gkg")
public class GkgEntity {

	@Id
   	@Column(name = "gkg_id")
	private Long gkgId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "world_id")
	private WorldEntity worldEntity;


	@Column(name = "gkg_datetime")
	private LocalDateTime gkgDatetime;

   	@Column(name = "gkg_theme")
	private Integer gkgTheme;

   	@Column(name = "gkg_tone")
	private String gkgTone;

   	@Column(name = "gkg_url")
	private String gkgUrl;

   	@Column(name = "gkg_location")
	private String gkgLocation;


}
