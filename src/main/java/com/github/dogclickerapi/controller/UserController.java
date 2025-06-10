package com.github.dogclickerapi.controller;

import com.github.dogclickerapi.dto.user.UserCreateRequestDto;
import com.github.dogclickerapi.dto.user.UserResponseDto;
import com.github.dogclickerapi.dto.user.UserUpdateRequestDto;
import com.github.dogclickerapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "User API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

  private final UserService userService;

  @Operation(summary = "Save user to Database")
  @PostMapping
  public ResponseEntity<String> saveUser(@RequestBody UserCreateRequestDto requestDto) {
    userService.saveUser(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @Operation(summary = "Get User by Telegram ID")
  @PostMapping("/{telegramId}")
  public ResponseEntity<UserResponseDto> getUserByTelegramId(@PathVariable Long telegramId) {
    return ResponseEntity.ok(userService.getUser(telegramId));
  }

  @Operation(summary = "Get Top Ten Users sorted By Score")
  @GetMapping("/top")
  public ResponseEntity<List<UserResponseDto>> getTopTenUsers() {
    return ResponseEntity.ok(userService.getTopTenUsers());
  }

  @Operation(summary = "Update User by Telegram ID")
  @PatchMapping("/{telegramId}/update")
  public ResponseEntity<String> updateUserByTelegramId(@PathVariable Long telegramId,
                                                       @RequestBody UserUpdateRequestDto requestDto) {
    userService.updateUser(telegramId, requestDto);
    return ResponseEntity.ok("User updated successfully");
  }

}
