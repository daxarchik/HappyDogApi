package com.github.dogclickerapi.service.impl;

import com.github.dogclickerapi.dto.settings.SettingsUpdateDto;
import com.github.dogclickerapi.dto.user.UserCreateRequestDto;
import com.github.dogclickerapi.dto.user.UserResponseDto;
import com.github.dogclickerapi.dto.user.UserUpdateRequestDto;
import com.github.dogclickerapi.entiity.Settings;
import com.github.dogclickerapi.entiity.User;
import com.github.dogclickerapi.repository.UserRepository;
import com.github.dogclickerapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public void saveUser(UserCreateRequestDto requestDto) {
    userRepository.save(requestDto.toEntity().init());
  }

  public UserResponseDto getUser(Long telegramId) {
    return getUserOrThrow(telegramId).toDto();
  }

  @Override
  public void updateUser(Long telegramId, UserUpdateRequestDto requestDto) {
    User user = getUserOrThrow(telegramId);

    BeanUtils.copyProperties(requestDto, user, "settings");

    SettingsUpdateDto sDto = requestDto.getSettings();
    if (sDto != null) {
      Settings settings = user.getSettings();
      settings.setSound(sDto.getSound());
      settings.setMusic(sDto.getMusic());
    }

    userRepository.save(user);
  }
  
  @Override
  public List<UserResponseDto> getTopTenUsers() {
    List<User> users = userRepository.findTop5ByOrderByScoreDesc();

    return users.stream()
        .map(User::toDto)
        .toList();
  }

  private User getUserOrThrow(Long telegramId) {
    return userRepository.findByTelegramId(telegramId)
            .orElseThrow(() -> new RuntimeException("User not found"));
  }
}
