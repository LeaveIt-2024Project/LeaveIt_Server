package com.example.domain.document.dao;

import com.example.domain.document.Place;

import java.util.List;



public interface SearchDAO {

    List<Place> searchPlace(int num, String text);

    void saveSearchLog(String  text);


}
