package com.github.dogclickerapi.dto.news;

import com.github.dogclickerapi.entiity.News;
import com.github.dogclickerapi.mapper.DtoMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class NewsCreateRequestDto {

  @Schema(example = "example")
  private String content;

  public News toEntity() {
    return MAPPER.toEntity(this);
  }

  private static final DtoMapper<News, NewsCreateRequestDto> MAPPER =
      new DtoMapper<>(News.class, NewsCreateRequestDto.class);
}
