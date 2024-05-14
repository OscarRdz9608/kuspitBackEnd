package com.kuspit.MiCasadeBolsa.web.controller;

import com.kuspit.MiCasadeBolsa.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kuspit.MiCasadeBolsa.domain.service.ActionService;

import java.util.List;

@RestController
@RequestMapping("/actions")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @GetMapping("/all")
    public ResponseEntity<List<Action>> getAll(){
        return new ResponseEntity<>(actionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{actionId}")
    public ResponseEntity<Action> getAction(@PathVariable("actionId") int actionId){
        return actionService.getAction(actionId).map(
                action -> new ResponseEntity<>(action, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("available/{userId}")
    public ResponseEntity<List<Action>> getAvailable(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(actionService.getAvailable(userId), HttpStatus.OK);
    }




}
