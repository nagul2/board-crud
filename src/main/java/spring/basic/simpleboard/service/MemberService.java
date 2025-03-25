package spring.basic.simpleboard.service;

import spring.basic.simpleboard.dto.MemberResponseDto;
import spring.basic.simpleboard.dto.SignUpResponseDto;

public interface MemberService {
    SignUpResponseDto signUp(String username, String password, Integer age);

    MemberResponseDto findById(Long id);

    void updatePassword(Long id, String oldPassword, String newPassword);
}
