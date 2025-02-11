package com.example.api.searchcontroller;


import com.example.common.model.request.FoodRequest;
import com.example.common.model.request.PlaceRequest;
import com.example.common.model.response.LogResponse;
import com.example.domain.document.PlaceLog;
import com.example.domain.searchservice.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
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
    @GetMapping("/tour/area/cat/{cat}")
    public List<PlaceRequest> getTypePlace(@PathVariable String cat, int num)  {
        log.info(cat);
        log.info(String.valueOf(num));
        return  searchService.getTypePlaceList(cat,num);
    }

    @GetMapping("/tour/area/type/{cat}")
    public List<PlaceRequest> getTypeAndAreaPlace(@PathVariable String cat,
                                           @RequestParam(required = false) String areaCode,
                                           int num)  {
        return  searchService.findTypeAndAreaPlace(cat,areaCode,num);
    }


    @GetMapping("/tour/area/search/input/{text}")
    public List<PlaceRequest> getSearchPlace(@PathVariable String text,@RequestParam int num){

        return  searchService.getSearchPlace(num,text);
    }

    @GetMapping("/tour/area/populars")
    public List<String> getPopularPlace(){
        return  searchService.getPopularPlace();
    }
    @PostMapping("/tour/area/log")
    public  void saveLog(@RequestBody LogResponse response){
         searchService.saveLog(response);
    }

    //    @GetMapping("/food/{areaCode}")
    //    public List<FoodRequest> getFoodAreaList(@RequestParam int page, @PathVariable String areaCode ) throws IOException {
    //
    //        return  searchService.getAreaFoodList(page,areaCode);
    //    }

    //    @GetMapping("/food/area/{areaCode}")
    //    public List<FoodRequest> getFoodAreaList(@RequestParam int page, @PathVariable String areaCode ) throws IOException {
    //
    //        return  searchService.getAreaFoodList(page,areaCode);
    //    }
}
