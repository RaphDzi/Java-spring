package com.example.exercice5.controller;


import com.example.exercice5.dto.LoginRequestDto;
import com.example.exercice5.dto.LoginResponseDto;
import com.example.exercice5.dto.RegisterRequestDto;
import com.example.exercice5.dto.RegisterResponseDto;
import com.example.exercice5.entity.ToDo;
import com.example.exercice5.exception.NotFoundException;
import com.example.exercice5.exception.UserAlreadyExistException;
import com.example.exercice5.security.JWTGenerator;
import com.example.exercice5.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ToDoController {
    private final AuthenticationManager authenticationManager;

    private final ToDoService todoService;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator generator;

    public ToDoController(AuthenticationManager authenticationManager, ToDoAppService toDoService, PasswordEncoder passwordEncoder, JWTGenerator generator) {
        this.authenticationManager = authenticationManager;
        this.toDoService = toDoAppService;
        this.passwordEncoder = passwordEncoder;
        this.generator = generator;
    }


    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDTO) throws NotFoundException {
        try {
            Authentication authentication = authenticationManager.authenticate(new ToDonamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(LoginResponseDto.builder().token(generator.generateToken(authentication)).build());
        }catch (Exception ex) {
            throw new NotFoundException();
        }
    }

    @PostMapping("register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDTO) throws UserAlreadyExistException {
        registerRequestDTO.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        ToDo toDo = toDoService.enregistrerUtilisateur(registerRequestDTO);
        return ResponseEntity.ok(RegisterResponseDto.builder()
                .id(toDo.getId())
                .titre(toDo.getTitre())
                .description(toDo.getDescription())
                .date(toDo.getDate())
                .isValidate(toDo.getIsValidate())
        );
    }
}
