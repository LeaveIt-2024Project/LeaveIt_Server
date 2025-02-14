package com.example.api.crawlingcontroller;

import com.example.common.model.request.TravelDestination;
import com.example.domain.crawlingservice.CrawlingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class CrawlingController {


    @Autowired
    private CrawlingService crawlingService;

    @GetMapping("/popular-destinations/{areaCode}")
    public List<TravelDestination> getPopularDestinations(@PathVariable String areaCode) {
        return crawlingService.fetchPopularDestinations(areaCode);
    }
}
