package com.github.dogclickerapi.entiity;

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
@Table(name = "settings")
public class Settings extends AbstractEntity {

  @Column(name = "sound", nullable = false)
  private Boolean sound;

  @Column(name = "music", nullable = false)
  private Boolean music;
}
