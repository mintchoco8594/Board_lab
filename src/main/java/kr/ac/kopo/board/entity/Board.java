package kr.ac.kopo.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")//writer제외한 객체 정보에 대한 문자열
public class Board extends BaseEntity{
    //primary key, bno 자동증가
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;
    private String content;


    //즉각(Eager) 로딩 방식은 기본설정이며 무조건 모든 관계에 대해 Join을 하기 때문에 불필요한 조인이 발생하게 된다. 데이터의 양이 많을시에는 즉각로딩 방식을 사용했을때 실행시간이 오래걸린다.
    //지연(Lazy) 로딩 방식 설정
    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;// 실제 board 테이블에는 wrier_email 컬럼이 생성되고 FK가 설정됨
}
