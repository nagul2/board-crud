package spring.basic.simpleboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.basic.simpleboard.dto.BoardResponseDto;
import spring.basic.simpleboard.dto.BoardWithAgeResponseDto;
import spring.basic.simpleboard.entity.Board;
import spring.basic.simpleboard.entity.Member;
import spring.basic.simpleboard.repository.BoardRepository;
import spring.basic.simpleboard.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    @Override
    public BoardResponseDto save(String title, String contents, String username) {

        Board board = new Board(title, contents);

        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);
        board.setMember(findMember);

        Board savedBoard = boardRepository.save(board);
        return new BoardResponseDto(savedBoard.getId(), board.getTitle(), board.getContents());
    }

    @Override
    public List<BoardResponseDto> findAll() {

        return boardRepository.findAll()
                .stream()
                .map(BoardResponseDto::toDto).toList();
    }

    @Override
    public BoardWithAgeResponseDto findById(Long id) {
        Board findBoard = boardRepository.findByIdOrElseThrow(id);
        Member findMember = findBoard.getMember();
        return new BoardWithAgeResponseDto(findBoard.getTitle(), findBoard.getContents(), findMember.getAge());
    }

    @Override
    public void delete(Long id) {
        Board findBoard = boardRepository.findByIdOrElseThrow(id);
        boardRepository.delete(findBoard);
    }
}
