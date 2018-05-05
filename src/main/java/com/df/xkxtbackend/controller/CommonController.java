package com.df.xkxtbackend.controller;

import com.df.xkxtbackend.domain.response.CollegeListResponse;
import com.df.xkxtbackend.domain.response.MessageListResponse;
import com.df.xkxtbackend.domain.response.ProfessionListResponse;
import com.df.xkxtbackend.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CommonController {

    @Autowired
    private CommonService commonService;

    @GetMapping(value = "/get_all_profession")
    public ProfessionListResponse getAllProfession() {
        return commonService.getAllProfession();
    }

    @GetMapping(value = "/get_all_college")
    public CollegeListResponse getAllCollege() {
        return commonService.getAllCollege();
    }

    @GetMapping(value = "/get_all_message")
    public MessageListResponse getAllMessage() {
        return commonService.getAllMessage();
    }
}
