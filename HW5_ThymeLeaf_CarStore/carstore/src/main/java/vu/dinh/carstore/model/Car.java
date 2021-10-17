package vu.dinh.carstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    int id;
    String model, manufacturer;
    long price, sales;
    String imgUrl;
}
