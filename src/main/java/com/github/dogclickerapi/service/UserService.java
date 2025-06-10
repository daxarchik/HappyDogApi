package com.github.dogclickerapi.service;

import com.github.dogclickerapi.dto.user.UserCreateRequestDto;
import com.github.dogclickerapi.dto.user.UserResponseDto;
import com.github.dogclickerapi.dto.user.UserUpdateRequestDto;

import java.util.List;

public interface UserService {

  void saveUser(UserCreateRequestDto requestDto);

  UserResponseDto getUser(Long telegramId);

  void updateUser(Long telegramId, UserUpdateRequestDto requestDto);

  List<UserResponseDto> getTopTenUsers();
}
