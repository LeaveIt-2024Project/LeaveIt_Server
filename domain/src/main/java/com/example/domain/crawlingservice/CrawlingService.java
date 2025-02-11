package com.example.domain.crawlingservice;

import com.example.common.model.request.TravelDestination;

import java.util.List;

public interface CrawlingService {

    List<TravelDestination> fetchPopularDestinations();
}
