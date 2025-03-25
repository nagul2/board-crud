package spring.basic.simpleboard.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "member")
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 로그인 아이디 - 필수, 유일
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * 비밀번호 - 필수
     */
    @Column(nullable = false)
    private String password;

    private Integer age;

    public Member() {
    }

    public Member(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
