//package com.edu.board.entity;
//
//import java.util.Date;
//
//import org.hibernate.annotations.ColumnDefault;
//
//import com.edu.board.DTO.BoardRequestDTO;
//import com.edu.user.entity.User;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//@Getter @Builder @ToString
//@NoArgsConstructor @AllArgsConstructor @Entity
//public class Board {
//	@Id 
//	@GeneratedValue(strategy = GenerationType.IDENTITY) 
//	@Column(name = "board_id")
//	private Long id;
//	
//	@Column(nullable = false, name = "title")
//	private String title;
//	
//	@Column(nullable = false, name = "content")
//	private String content;
//	
//	@ColumnDefault("0")
//	private Integer viewCount;
//	
//	@ColumnDefault("0")
//	private Integer likeCount;
//	
//	@Column(name = "is_secret", nullable = false)
//	@ColumnDefault("false")
//	private Boolean isSecret;
//	
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "User_id")
//    private User writer;	
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Builder.Default
//	@Column(columnDefinition = "timestamp default current_timestamp")
//	private Date createDate = new Date();
//	
//	public Board updateBoard(BoardRequestDTO boardRequestDTO) {
//        this.title = boardRequestDTO.getTitle();
//        this.content = boardRequestDTO.getContent();
//        this.isSecret = boardRequestDTO.getIsSecret();
//        return this;
//    }
//	
//	
//	public void viewCountUp(Board board) {
//		board.viewCount++;
//	}
//}
//
