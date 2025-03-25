package spring.basic.simpleboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import spring.basic.simpleboard.dto.MemberResponseDto;
import spring.basic.simpleboard.dto.SignUpResponseDto;
import spring.basic.simpleboard.entity.Member;
import spring.basic.simpleboard.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String username, String password, Integer age) {
        Member member = new Member(username, password, age);
        Member savedMember = memberRepository.save(member);
        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getAge());
    }

    @Override
    public MemberResponseDto findById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id " + id);
        }
        Member findMember = optionalMember.get();
        return new MemberResponseDto(findMember.getUsername(), findMember.getAge());
    }
}
