package com.sportfemme.en_avant_toutes.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;  

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestAPIResponse {
    private int status;
    private String message;
}