package vu.dinh.carstore.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import vu.dinh.carstore.model.Car;

@Component
public class CarDao implements DAO<Car> {
    List<Car> listCar = new ArrayList<>();

    public CarDao() {
        try {
          File file = ResourceUtils.getFile("classpath:static/carFile.json");
          ObjectMapper mapper = new ObjectMapper();
          listCar.addAll(mapper.readValue(file, new TypeReference<List<Car>>(){}));
          listCar.forEach(System.out::println);
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Car> getAll() {
        // TODO Auto-generated method stub
        return listCar;
    }

    @Override
    public Optional<Car> getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(Car t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Car t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Car> sorf(long price) {
        // TODO Auto-generated method stub
        return null;
    }

}
