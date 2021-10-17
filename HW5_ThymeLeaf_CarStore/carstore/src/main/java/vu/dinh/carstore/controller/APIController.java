package vu.dinh.carstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vu.dinh.carstore.model.Car;
import vu.dinh.carstore.repository.DAO;

@Controller
@RequestMapping("/car")
public class APIController {
    @Autowired
    private DAO<Car> carDao;

    @GetMapping
    public ResponseEntity<?> listAll(){
        List<Car> result = carDao.getAll();
        return ResponseEntity.ok(result);
    }
}
