package com.piddamsetty.praneetwebpro1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rewatiraman.
 */
@RestController
public class WebPoint {
    @RequestMapping("/")
    public String root() {
        return "Hello World!!";
    }
}
