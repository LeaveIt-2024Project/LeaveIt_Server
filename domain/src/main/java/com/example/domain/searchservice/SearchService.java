package com.example.domain.searchservice;

import com.example.common.model.request.TouristRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface SearchService {

    List<TouristRequest> getTourist() throws IOException;
}
