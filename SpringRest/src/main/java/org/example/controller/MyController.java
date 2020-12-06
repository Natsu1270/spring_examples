package org.example.controller;

import org.example.dao.StarDao;
import org.example.entity.Star;
import org.example.exception.StarNotFoundException;
import org.example.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    private static final List<Star> stars = new ArrayList<>(Arrays.asList(
            new Star(1L,"Sun", 13, 20),
            new Star(2L,"CY-123", 22, 40)
    ));

    private final StarService starService;

    @Autowired
    public MyController(StarService starService) {
        this.starService = starService;
    }

    @GetMapping("/hello")
    public String restHello() {
        return "Hello World";
    }

    @GetMapping("/stars")
    public ResponseEntity<List<Star>> getListStar() {
        return new ResponseEntity<>(starService.getStars(), HttpStatus.OK);
    }

    @PostMapping("/stars")
    public void createStar(@RequestBody Star star) {
        starService.saveOrUpdate(star);
    }

    @GetMapping("/stars/{name}")
    public ResponseEntity<Star> getStar(@PathVariable String name) {
        if (name.equals("1")) {
            throw new RuntimeException("Can not be 1 babe");
        }
        Star result = stars
                .stream()
                .filter(item -> item.getName().equals(name))
                .findFirst().orElse(null);
        if (result == null) throw new StarNotFoundException("Can not find any star matches given name!");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
