package com.piddamsetty.praneetwebpro1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by rewatiraman.
 */
@RestController
public class WebPoint {

    @RequestMapping("/")
    public String root() {
        System.out.println("New request for home");
        String content = "index.html";
        return content;
    }

}
