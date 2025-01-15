package com.example.domain.document.dao;


import com.example.domain.document.Search;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


public interface SearchDAO {


    List<Search> findTouristAll() throws IOException;

}
