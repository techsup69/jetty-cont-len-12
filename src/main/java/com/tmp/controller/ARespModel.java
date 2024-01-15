package com.tmp.controller;

import jakarta.validation.constraints.Pattern;

public class ARespModel {

    @Pattern(regexp = "[a-z]+")
    public String msg;

}
