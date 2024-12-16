package com.sportfemme.en_avant_toutes.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserDTO {
    Long id;
    String username;
}