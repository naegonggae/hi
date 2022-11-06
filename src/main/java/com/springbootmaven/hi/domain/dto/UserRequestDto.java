package com.springbootmaven.hi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRequestDto {
    private String id;
    private String name;
    private String password;

}
