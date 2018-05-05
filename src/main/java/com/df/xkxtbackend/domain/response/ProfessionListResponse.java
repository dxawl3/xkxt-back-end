package com.df.xkxtbackend.domain.response;

import com.df.xkxtbackend.domain.entity.Profession;

import java.util.List;

public class ProfessionListResponse {

    private List<Profession> professions;

    public ProfessionListResponse(List<Profession> professions) {
        this.professions = professions;
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<Profession> professions) {
        this.professions = professions;
    }
}
