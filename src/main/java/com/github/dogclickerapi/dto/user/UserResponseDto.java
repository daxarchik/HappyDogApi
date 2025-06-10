package com.github.dogclickerapi.dto.user;

import com.github.dogclickerapi.dto.settings.SettingsResponseDto;
import lombok.Data;

import java.time.Instant;

@Data
public class UserResponseDto {

  private Long telegramId;

  private String username;

  private Long score;

  private Integer upgrade1;

  private Integer upgrade2;

  private SettingsResponseDto settings;

  private Instant updatedAt;
}
