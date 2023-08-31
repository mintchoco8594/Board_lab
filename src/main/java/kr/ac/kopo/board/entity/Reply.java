package kr.ac.kopo.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
public class Reply extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;
    private String replyer;

    @ManyToOne
    private Board board;//실제 reply 테이블에는 board_bno 컬럼이 생성되고 FK(Board 테이블의 bno 컬럼값만 참조하기 위해)가 설정됨
}
