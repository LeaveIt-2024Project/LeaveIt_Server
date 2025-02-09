package com.example.domain.document.dao;


import com.example.domain.document.Food;
import com.example.domain.document.Place;

import java.io.IOException;
import java.util.List;


public interface CategoryDAO {


    List<Place> findAreaPlace(String  area, int num);

    List<Place> findTypePlace(String cat,int num);
    List<Place> findTypeAndAreaPlace(String cat,String areaCode,int num);
    List<Place> searchAreaPlace(String area,int num);

    void saveAreaPlace(String cat,int num);


    List<Food> findAreaFood(int num, String areaCode) throws  IOException;
}
