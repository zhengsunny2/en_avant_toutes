package com.sportfemme.en_avant_toutes.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserLoginDTO {
    private String username;
    private String password;

}
