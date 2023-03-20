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

	@Column(name="world_id")
	private Long worldId;

	@Column(name = "gkg_time")
	private LocalDateTime gkgTime;

   	@Column(name = "gkg_source")
	private Integer gkgSource;

	@Column(name = "gkg_domain")
	private Integer gkgDomain;

   	@Column(name = "gkg_themes")
	private String gkgThemes;

   	@Column(name = "gkg_en_themes")
	private String gkgEnThemes;

   	@Column(name = "gkg_tone")
	private String gkgTone;

	@Column(name = "gkg_imgurl")
	private Integer gkgImgurl;


}
