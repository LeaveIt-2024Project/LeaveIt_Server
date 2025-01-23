package com.example.domain.document.dao;


import com.example.domain.document.Food;
import com.example.domain.document.Place;

import java.io.IOException;
import java.util.List;


public interface SearchDAO {


    List<Place> findAreaPlace(String  area, int num);

    List<Place> findTypePlace(String area,int num);
    List<Place> searchAreaPlace(String area,int num);

    void saveAreaPlace(String area,int num);


    List<Food> findAreaFood(int num, String areaCode) throws  IOException;
}
