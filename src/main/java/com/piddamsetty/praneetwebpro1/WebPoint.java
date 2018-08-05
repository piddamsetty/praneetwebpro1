package com.piddamsetty.praneetwebpro1;

import com.piddamsetty.praneetwebpro1.services.FileServices;
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
    String template = fileServices.resourceFileRead("template");

    public String applyTemplate(String content) {
        String t1 = template.replace("##leftLinks##","<li><a href=\"#\">/</a></li>");
        return t1.replace("##bodycontent##",content);
    }

    @RequestMapping("/")
    public String root() {
        System.out.println("New request for home");
        String content = fileServices.resourceFileRead("index.html");
        return applyTemplate(content);
    }

    @RequestMapping("/blog/{page}")
    public String getPage(@PathVariable String page) {
        System.out.println("New request to get blog for page: "+page);
        String content = fileServices.resourceFileRead(page);
        return applyTemplate(content);
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
