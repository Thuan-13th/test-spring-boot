package com.project.server.infrastructure.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author nguyencongthang2509
 */
@AllArgsConstructor
@Getter
@Setter
public class ApiError {

    private String message;

}