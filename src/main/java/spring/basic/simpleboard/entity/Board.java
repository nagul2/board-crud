package spring.basic.simpleboard.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "board")
@Getter
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    /**
     * 긴 텍스트
     */
    @Column(columnDefinition = "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Board() {
    }

    public Board(String title, String content) {
        this.title = title;
        this.contents = content;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
