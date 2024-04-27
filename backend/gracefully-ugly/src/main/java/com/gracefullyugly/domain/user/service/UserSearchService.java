package com.gracefullyugly.domain.user.service;

import com.gracefullyugly.domain.user.dto.ProfileResponse;
import com.gracefullyugly.domain.user.dto.UserDtoUtil;
import com.gracefullyugly.domain.user.dto.UserResponse;
import com.gracefullyugly.domain.user.entity.User;
import com.gracefullyugly.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserSearchService {

    private final UserRepository userRepository;

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(userId + "에 해당하는 사용자가 없습니다."));
    }

    public ProfileResponse getProfile(Long userId) {
        User findUser = findById(userId);

        return UserDtoUtil.userToProfileResponse(findUser);
    }

    public UserResponse getUser(Long userId) {
        User findUser = findById(userId);

        return UserDtoUtil.userToUserResponse(findUser);
    }
}
