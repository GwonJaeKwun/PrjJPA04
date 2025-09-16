package com.green.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor  //기본생성자
@AllArgsConstructor
@SequenceGenerator(
		name="COMMENT_SEQ_GENERATOR",
		sequenceName="COMMENTS_SEQ",  //create sequence COMMENT_SEQ
		initialValue=1,     //초기값  start with 1
		allocationSize=1    //증가치  increment by1)
		)
public class Comments {
		
	@Id                         //primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	         generator = "COMMENT_SEQ_GENERATOR")           //번호자동증가 sequence
	private Long id;
	
	// @Column(name="body", nullable=true, length=255)
	// Oracle 11g varchar2 최대4000, CLOB
	// Oracle 12c varchar2 최대 32000 -> 별도설정 필요
	@Column
	private String body;
	
	@Column
	private String nickname;

	
	//외래키 설정
	@ManyToOne                     // 외래키 다대일관계
	@JoinColumn(name="article_id") // 외래키 칼럼
	private Article article;       // 연결될 entity 객체의 이름
	
}
