package com.github.dogclickerapi.service;

import com.github.dogclickerapi.dto.news.NewsCreateRequestDto;
import com.github.dogclickerapi.dto.news.NewsResponseDto;

import java.util.List;

public interface NewsService {

  void saveNews(NewsCreateRequestDto requestDto);

  List<NewsResponseDto> getNewsByPageable(Integer page, Integer size);
}

