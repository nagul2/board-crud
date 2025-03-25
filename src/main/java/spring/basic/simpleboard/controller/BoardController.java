package spring.basic.simpleboard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.basic.simpleboard.dto.BoardResponseDto;
import spring.basic.simpleboard.dto.BoardWithAgeResponseDto;
import spring.basic.simpleboard.dto.CreateBoardRequestDto;
import spring.basic.simpleboard.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponseDto> save(@RequestBody CreateBoardRequestDto requestDto) {

        BoardResponseDto savedBoard = boardService.save(requestDto.getTitle(), requestDto.getContents(), requestDto.getUsername());

        return new ResponseEntity<>(savedBoard, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAll() {
        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();
        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardWithAgeResponseDto> findById(@PathVariable Long id) {
        BoardWithAgeResponseDto boardWithAgeResponseDto = boardService.findById(id);
        return new ResponseEntity<>(boardWithAgeResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
