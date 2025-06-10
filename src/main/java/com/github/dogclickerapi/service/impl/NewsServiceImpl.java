package com.github.dogclickerapi.service.impl;

import com.github.dogclickerapi.dto.news.NewsCreateRequestDto;
import com.github.dogclickerapi.dto.news.NewsResponseDto;
import com.github.dogclickerapi.entiity.News;
import com.github.dogclickerapi.repository.NewsRepository;
import com.github.dogclickerapi.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

  private static final Sort DEFAULT_SORT = Sort.by("createdAt").descending();

  private final NewsRepository newsRepository;

  @Override
  public void saveNews(NewsCreateRequestDto requestDto) {
    newsRepository.save(requestDto.toEntity());
  }

  @Override
  public List<NewsResponseDto> getNewsByPageable(Integer page, Integer size) {
    Pageable pageable = PageRequest.of(page, size, DEFAULT_SORT);
    Page<News> news = newsRepository.findAll(pageable);

    return news.stream()
        .map(News::toDto)
        .toList();
  }
}
