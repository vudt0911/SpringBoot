package vu.dinh.carstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vu.dinh.carstore.model.Car;
import vu.dinh.carstore.repository.DAO;

@Controller
@RequestMapping("/thyme")
public class ThymeController {
    @Autowired
    private DAO<Car> carDaoThyme;
    @GetMapping("")
    public String listAll(Model model){
        model.addAttribute("cars", carDaoThyme.getAll());
        return "listAll";
    }
}
