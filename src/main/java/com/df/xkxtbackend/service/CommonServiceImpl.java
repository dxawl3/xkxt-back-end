package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.response.CollegeListResponse;
import com.df.xkxtbackend.domain.response.MessageListResponse;
import com.df.xkxtbackend.domain.response.ProfessionListResponse;
import com.df.xkxtbackend.repository.CollegeRepository;
import com.df.xkxtbackend.repository.MessageRepository;
import com.df.xkxtbackend.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private ProfessionRepository professionRepository;

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public ProfessionListResponse getAllProfession() {
        return new ProfessionListResponse(professionRepository.findAll());
    }

    @Override
    public CollegeListResponse getAllCollege() {
        return new CollegeListResponse(collegeRepository.findAll());
    }

    @Override
    public MessageListResponse getAllMessage() {
        return new MessageListResponse(messageRepository.findAll());
    }
}
