package com.tmp.controller;

import jakarta.validation.constraints.Pattern;

public class AReqModel {

    @Pattern(regexp = "[a-z]+")
    public String input;

}
