package com.github.dogclickerapi.dto.user;

import com.github.dogclickerapi.entiity.User;
import com.github.dogclickerapi.mapper.DtoMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserCreateRequestDto {

  @Schema(example = "321321")
  private Long telegramId;

  @Schema(example = "JohnDoe")
  private String username;

  public User toEntity() {
    return MAPPER.toEntity(this);
  }

  private static final DtoMapper<User, UserCreateRequestDto> MAPPER =
      new DtoMapper<>(User.class, UserCreateRequestDto.class);
}
