package com.tmp.controller;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AController {

//    //3.
//    @PostMapping("/controller/**")
//    public String controller() {
//        return "{}";
//    }

    //4.
    @PostMapping("/controller/**")
    @Valid
    public ARespModel controller(@Valid @RequestBody AReqModel req) {
        final ARespModel respModel = new ARespModel();
        respModel.msg = req.input;
        return respModel;
    }

}
