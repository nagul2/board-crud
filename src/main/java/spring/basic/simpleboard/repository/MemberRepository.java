package spring.basic.simpleboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import spring.basic.simpleboard.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    default Member findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    Optional<Member> findMemberByUsername(String username);

    default Member findMemberByUsernameOrElseThrow(String username) {
        return findMemberByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = " + username));
    }


}
