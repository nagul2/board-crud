package spring.basic.simpleboard.service;

import spring.basic.simpleboard.dto.BoardResponseDto;
import spring.basic.simpleboard.dto.BoardWithAgeResponseDto;

import java.util.List;

public interface BoardService {
    BoardResponseDto save(String title, String contents, String username);

    List<BoardResponseDto> findAll();

    BoardWithAgeResponseDto findById(Long id);

    void delete(Long id);
}
