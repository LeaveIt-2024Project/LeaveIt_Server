package com.example.domain.document.dao;

import com.example.domain.document.Place;
import com.example.domain.document.PlaceLog;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;


public interface SearchDAO {

    List<Place> searchPlace(int num, String text);

    void saveSearchLog(List<PlaceLog> batchLogs);

    List<String> searchPopularPlace();
}
