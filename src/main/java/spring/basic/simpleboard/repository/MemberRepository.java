package spring.basic.simpleboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.basic.simpleboard.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
