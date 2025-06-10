package com.github.dogclickerapi.controller;

import com.github.dogclickerapi.dto.news.NewsCreateRequestDto;
import com.github.dogclickerapi.dto.news.NewsResponseDto;
import com.github.dogclickerapi.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "News API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/news")
public class NewsController {

  private final NewsService newsService;

  @Operation(summary = "Save News to Database")
  @PostMapping
  public ResponseEntity<String> login(@RequestBody NewsCreateRequestDto requestDto) {
    newsService.saveNews(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @Operation(summary = "Get News from Database with Pageable")
  @GetMapping
  public ResponseEntity<List<NewsResponseDto>> getNews(@RequestParam(defaultValue = "0") Integer page,
                                                       @RequestParam(defaultValue = "10") Integer size) {
    return ResponseEntity.ok(newsService.getNewsByPageable(page, size));
  }
}
