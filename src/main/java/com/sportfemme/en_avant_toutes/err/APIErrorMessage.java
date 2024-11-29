package com.sportfemme.en_avant_toutes.err;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class APIErrorMessage {
   
    private int code;
    private String message;
    private String details;

    
}
