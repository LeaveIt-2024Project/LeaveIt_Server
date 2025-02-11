package com.example.api.crawlingcontroller;

import com.example.common.model.request.TravelDestination;
import com.example.domain.crawlingservice.CrawlingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CrawlingController {


    @Autowired
    private CrawlingService crawlingService;

    @GetMapping("/popular-destinations")
    public List<TravelDestination> getPopularDestinations() {
        return crawlingService.fetchPopularDestinations();
    }
}
