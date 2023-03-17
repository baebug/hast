package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "mention")
public class MentionEntity {

	@Id
   	@Column(name = "mention_id")
	private Long mentionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "world_id")
	private WorldEntity worldEntity;


	@Column(name = "event_datetime")
	private LocalDateTime eventDatetime;

   	@Column(name = "mention_datetime")
	private LocalDateTime mentionDatetime;

   	@Column(name = "mention_url")
	private String mentionUrl;


}
