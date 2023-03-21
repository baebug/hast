package com.cst.hast.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "safety")
public class EventEntity {

	@Id
	@Column(name = "event_id")
	private Long eventId;

	@Column(name = "export_id")
	private Long exportId;

	@Column(name = "export_country")
	private String exportCountry;

}
