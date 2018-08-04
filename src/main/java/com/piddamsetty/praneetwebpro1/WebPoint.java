package com.piddamsetty.praneetwebpro1;

import com.piddamsetty.praneetwebpro1.services.FileServices;
import com.piddamsetty.praneetwebpro1.services.PiServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by rewatiraman.
 */
@RestController
public class WebPoint {

    FileServices fileServices = new FileServices();
    PiServices piServices = new PiServices();
    String template = fileServices.resourceFileRead("template");

    @RequestMapping("/")
    public String root() {
        System.out.println("New request for home");
        String content = fileServices.resourceFileRead("index.html");
        return template.replace("##bodycontent##",content);
    }

    @RequestMapping("/blog/{page}")
    public String getPage(@PathVariable String page) {
        System.out.println("New request to get blog for page: "+page);
        return fileServices.resourceFileRead(page);
    }

    @RequestMapping("/friends")
    public String getListOfMyFriends() {
        return "A,B,C,D";
    }

    @RequestMapping("/random")
    public int findRandomInteger() {
        Random number = new Random();
        return number.nextInt();
    }

    @RequestMapping("/calculate/{operation}/{i}/{j}")
    public Integer calculate(@PathVariable Integer i, @PathVariable Integer j, @PathVariable String operation) {
        if(operation.toLowerCase().equals("multiply")) {
            return i*j;
        }
        if(operation.toLowerCase().equals("add")) {
            return i+j;
        }
        if(operation.toLowerCase().equals("divide")) {
            return i/j;
        }
        if(operation.toLowerCase().equals("substract")) {
            return i-j;
        }
        return null;
    }

//    @RequestMapping("/pi/on/{i}")
//    public void pinon(@PathVariable Integer i) {
//        piServices.turnOn(i);
//    }

}
