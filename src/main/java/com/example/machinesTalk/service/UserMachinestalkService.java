package com.example.machinesTalk.service;

import com.example.machinesTalk.model.UserMachinestalk;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserMachinestalkService {
    Page<UserMachinestalk> getUsers(String gender, String status, int page, int size) throws JsonProcessingException, InterruptedException;
    public List<UserMachinestalk> findAllUsersFromUrlAndSaveThem(String gender, String status, int page, int size) throws JsonProcessingException;
    int getNbreTotalPagesFromUrl(String gender, String status, int page) throws JsonProcessingException;
}
