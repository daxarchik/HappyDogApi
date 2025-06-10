package com.github.dogclickerapi.dto.user;

import com.github.dogclickerapi.dto.settings.SettingsUpdateDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserUpdateRequestDto {

  @Schema(example = "10000")
  private Long score;

  @Schema(example = "10")
  private Integer upgrade1;

  @Schema(example = "10")
  private Integer upgrade2;

  private SettingsUpdateDto settings;
}
