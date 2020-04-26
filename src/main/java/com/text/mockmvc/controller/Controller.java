package com.text.mockmvc.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by li wen ya on 2020/4/25
 */
@RestController
@RequestMapping("/mock")
public class Controller {

    @GetMapping
    public String test(){
        return "hello mock mvc";
    }

    @DeleteMapping
    public void delete(){
        System.out.println("删除成功!");
    }

}
