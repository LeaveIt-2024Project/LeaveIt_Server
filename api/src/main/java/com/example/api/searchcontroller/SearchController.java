package com.example.api.searchcontroller;


import com.example.common.model.request.FoodRequest;
import com.example.common.model.request.PlaceRequest;
import com.example.domain.searchservice.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private  final SearchService searchService;

    @GetMapping("/tour/area/{areaCode}")
    public List<PlaceRequest> getTourist(@PathVariable String areaCode,@RequestParam int num){

        return  searchService.getAreaPlaceList(areaCode,num);
    }


    @GetMapping("/tour/area/search/{place}")
    public List<PlaceRequest> getSearchTourist(@PathVariable String place,@RequestParam int num){

        return  searchService.getSearchAreaPlaceList(place,num);
    }

    @GetMapping("/tour/area/type/{cat}")
    public List<PlaceRequest> getTypePlace(@PathVariable String cat, int num)  {

        return  searchService.getTypePlaceList(cat,num);
    }

//    @GetMapping("/food/{areaCode}")
//    public List<FoodRequest> getFoodAreaList(@RequestParam int page, @PathVariable String areaCode ) throws IOException {
//
//        return  searchService.getAreaFoodList(page,areaCode);
//    }

    @GetMapping("/food/area/{areaCode}")
    public List<FoodRequest> getFoodAreaList(@RequestParam int page, @PathVariable String areaCode ) throws IOException {

        return  searchService.getAreaFoodList(page,areaCode);
    }
}
