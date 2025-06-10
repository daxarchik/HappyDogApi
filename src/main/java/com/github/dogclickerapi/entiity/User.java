package com.github.dogclickerapi.entiity;

import com.github.dogclickerapi.dto.user.UserResponseDto;
import com.github.dogclickerapi.mapper.DtoMapper;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "users")
public class User extends AbstractEntity {

  @Column(name = "telegram_id")
  private Long telegramId;

  @Column(name = "username")
  private String username;

  @Column(name = "score")
  private Long score;

  @Column(name = "upgrade1")
  private Integer upgrade1;

  @Column(name = "upgrade2")
  private Integer upgrade2;

  @OneToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "settings_id", nullable = false, unique = true)
  private Settings settings;

  public User init() {
    score = 0L;
    upgrade1 = 1;
    upgrade2 = 1;

    this.settings = new Settings();
    settings.setMusic(true);
    settings.setSound(true);

    return this;
  }

  public UserResponseDto toDto() {
    return MAPPER.toDto(this);
  }

  private static final DtoMapper<User, UserResponseDto> MAPPER = new DtoMapper<>(User.class, UserResponseDto.class);
}
