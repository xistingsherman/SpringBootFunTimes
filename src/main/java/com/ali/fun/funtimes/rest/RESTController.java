package com.ali.fun.funtimes.rest;

import com.ali.fun.funtimes.annotations.SampleAnno;
import com.ali.fun.funtimes.request.model.Alligator;
import com.ali.fun.funtimes.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebInputException;

@RestController
@RequestMapping("/foo")
public class RESTController {

    private final ApplicationContext applicationContext;
    private Service service;

    public RESTController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Autowired
    private void setService(Service service) {
        this.service=service;
    }

    @GetMapping
    public String foo(@RequestParam String favAnimal){
        return favAnimal;
    }

    @PostMapping
    public Alligator testJacksonIssue(@RequestBody Alligator alligator) {
        return alligator;
    }

    @SampleAnno
    public void bar() {
        var annotationsOnThisClass = this.getClass().getDeclaredAnnotations();
    }

    @ExceptionHandler(ServerWebInputException.class)
    public ResponseEntity<String> handleBadJsonConversion(ServerWebInputException exception) {
        var cause = exception.getCause();
        if (cause instanceof DecodingException) {
            return ResponseEntity.badRequest().body("hello");
//            return ResponseEntity.badRequest().body(cause.getMessage());
        }

        return ResponseEntity.internalServerError().build();
    }
}
