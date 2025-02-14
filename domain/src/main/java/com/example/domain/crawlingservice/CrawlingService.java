package com.example.domain.crawlingservice;

import com.example.common.model.request.TravelDestination;

import java.util.List;
import java.util.Map;

public interface CrawlingService {

    List<TravelDestination> fetchPopularDestinations(String areaCode);
}
