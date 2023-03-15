package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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

   	@Column(name = "gkg_code")
	private String gkgCode;

   	@Column(name = "gkg_theme")
	private Integer gkgTheme;

   	@Column(name = "gkg_url")
	private String gkgUrl;


}
