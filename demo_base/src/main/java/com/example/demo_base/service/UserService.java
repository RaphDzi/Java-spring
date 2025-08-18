package com.example.demo_base.service;

import com.example.demo_base.dto.UserReceiveDto;
import com.example.demo_base.dto.UserResponseDto;
import com.example.demo_base.exception.NotFoundException;
import com.example.demo_base.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserResponseDto create(UserReceiveDto UserReceiveDto){
        return userRepository.save(UserReceiveDto.dtoToEntity()).entityToDto();
    }

    public UserResponseDto get(long id){
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}

