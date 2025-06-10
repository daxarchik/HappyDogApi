package com.github.dogclickerapi.dto.settings;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SettingsUpdateDto {

  @Schema(example = "true")
  private Boolean sound;

  @Schema(example = "true")
  private Boolean music;
}
