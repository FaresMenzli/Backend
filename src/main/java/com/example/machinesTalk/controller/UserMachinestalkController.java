package com.example.machinesTalk.controller;

import com.example.machinesTalk.model.HttpResponse;
import com.example.machinesTalk.service.UserMachinestalkService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserMachinestalkController {
    @Autowired
    private UserMachinestalkService userMachinestalkService;

    @GetMapping("/users")
    public ResponseEntity<HttpResponse> getUsers(@RequestParam Optional<String> gender,
                                                 @RequestParam Optional<String> status,
                                                 @RequestParam Optional<Integer> page,
                                                 @RequestParam Optional<Integer> size) throws InterruptedException, JsonProcessingException {
        return ResponseEntity.ok().body(
                HttpResponse.builder().timestamp(LocalDateTime.now().toString())
                        .data(Map.of("page", userMachinestalkService.getUsers(gender.orElse(""), status.orElse(""), page.orElse(0), size.orElse(10))))
                        .message("Users Retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
}
