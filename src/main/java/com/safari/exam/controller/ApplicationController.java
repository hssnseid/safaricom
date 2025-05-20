package com.safari.exam.controller;

import com.safari.exam.dto.ApplicationDto;
import com.safari.exam.dto.ReversalDto;
import com.safari.exam.service.ApplicationService;
import com.safari.exam.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applications/")
public class ApplicationController {


    @Autowired
    private ApplicationService applicationService;

    @PostMapping("submit")
    public ResponseEntity<?> saveApplication(@RequestBody ApplicationDto applicationDto) {
        try {
            ApplicationDto response = applicationService.saveApplication(applicationDto);
            return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("success", "Reversal successfully.", response));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse("Failed", e.getMessage(), applicationDto));
        }
    }

}
