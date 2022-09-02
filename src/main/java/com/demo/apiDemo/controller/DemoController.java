package com.demo.apiDemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/demo")
public class DemoController {

    @RequestMapping("/nogetpost")
    public String testApi() {
        /**
         * 어노테이션 RequestMapping은 경로 뒤에 method를 명시하지 않으면 get, post 모두 처리해준다.
         */
        return "RequestMapping with no GET/POST success";
    }


    @RequestMapping(value = "/onlyget", method = RequestMethod.GET)
    public String testApi2() {
        /**
         * 어노테이션 RequestMapping 뒤에 method GET 만을 명시한 경우는 GET으로만 처리됨.
         */
        return "RequestMapping only GET success";
    }
    
    @RequestMapping(value = "/withgetpost", method = RequestMethod.GET)
    public String testApi3() {
        /**
         * 어노테이션 RequestMapping 경로 뒤에 method GET과 POST를 같이 명시한 경우는 모두 처리됨.
         */
        return "RequestMapping with GET and POST success, this is GET";
    }

    @RequestMapping(value = "/withgetpost", method = RequestMethod.POST)
    public String testApi4() {
        /**
         * 어노테이션 RequestMapping 경로 뒤에 method GET과 POST를 같이 명시한 경우는 모두 처리됨.
         */
        return "RequestMapping with GET and POST success, this is POST";
    }

    @GetMapping(value = "/getpostmapping")
    public String testApi5() {
        /**
         * Spring 4.3부터 추가된 신규 어노테이션
         * RequestMapping 경로 뒤에 method 명시한 것과 같음.
         */
        return "GetMapping success";
    }

    @PostMapping(value = "/getpostmapping")
    public String testApi6() {
        /**
         * Spring 4.3부터 추가된 신규 어노테이션
         * RequestMapping 경로 뒤에 method 명시한 것과 같음.
         */
        return "PostMapping success";
    }
}
