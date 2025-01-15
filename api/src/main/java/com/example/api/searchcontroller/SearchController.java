package com.example.api.searchcontroller;


import com.example.common.model.request.TouristRequest;
import com.example.domain.searchservice.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private  final SearchService searchService;

    @GetMapping("/test")
    public List<TouristRequest> getTourist() throws IOException {

        return  searchService.getTourist();
    }
}
