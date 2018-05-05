package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.response.CollegeListResponse;
import com.df.xkxtbackend.domain.response.MessageListResponse;
import com.df.xkxtbackend.domain.response.ProfessionListResponse;

public interface CommonService {
    ProfessionListResponse getAllProfession();

    CollegeListResponse getAllCollege();

    MessageListResponse getAllMessage();
}
