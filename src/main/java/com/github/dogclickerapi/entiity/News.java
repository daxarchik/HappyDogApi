package com.github.dogclickerapi.entiity;

import com.github.dogclickerapi.dto.news.NewsResponseDto;
import com.github.dogclickerapi.mapper.DtoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "news")
public class News extends AbstractEntity {

  @Column(name = "content")
  private String content;

  public NewsResponseDto toDto() {
    return MAPPER.toDto(this);
  }

  private static final DtoMapper<News, NewsResponseDto> MAPPER =
      new DtoMapper<>(News.class, NewsResponseDto.class);
}
