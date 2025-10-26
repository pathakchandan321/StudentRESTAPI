package com.chandanpathak2005.gmail.com.RestAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private long Id;
    private String name;
    private String email;
}
