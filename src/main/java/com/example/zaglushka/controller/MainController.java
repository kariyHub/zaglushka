package com.example.zaglushka.controller;

import com.example.zaglushka.data.DataModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MainController {

    private List<DataModel> dataModels = new ArrayList();
    private final AtomicLong counter = new AtomicLong();

    public MainController(){
        dataModels.add(new DataModel((int) counter.incrementAndGet(), "UA", "8:00",
        "22.00","https://start.spring.io/",1));
    }

    @GetMapping(value = "/")
    public ResponseEntity index() {
        return ResponseEntity.ok(dataModels);
    }

    @GetMapping(value = "/bucket")
    public ResponseEntity getBucket(@RequestParam(value="id") Long id) {
        DataModel itemToReturn = null;
        for(DataModel bucket : dataModels){
            if(bucket.getId() == id)
                itemToReturn = bucket;
        }

        return ResponseEntity.ok(itemToReturn);
    }

    @PostMapping(value = "/")
    public ResponseEntity addToModelList(@RequestParam(value="reg") String reg,
                                         @RequestParam(value = "time1") String time1,
                                         @RequestParam(value = "time2") String time2,
                                         @RequestParam(value = "url") String url,
                                         @RequestParam(value = "pow")int pow){
        dataModels.add(new DataModel((int) counter.incrementAndGet(), reg,time1,time2,url,pow));
        return ResponseEntity.ok(dataModels);
    }

    @PutMapping(value = "/")
    public ResponseEntity updateBucketList(@RequestParam(value="reg") String reg,
                                           @RequestParam(value = "time1")String time1,
                                           @RequestParam(value = "time2")String time2,
                                           @RequestParam(value = "url")String url,
                                           @RequestParam(value = "pow") int pow,
                                           @RequestParam(value="id") Long id) {
        dataModels.forEach(dataModel ->  {
            if(dataModel.getId() == id){
                dataModel.setPow(pow);
                dataModel.setReg(reg);
                dataModel.setTime1(time1);
                dataModel.setTime2(time2);
                dataModel.setUrl(url);

            }
        });
        return ResponseEntity.ok(dataModels);
    }

    @DeleteMapping(value = "/")
    public ResponseEntity removeBucketList(@RequestParam(value="id") Long id) {
        DataModel itemToRemove = null;
        for(DataModel bucket : dataModels){
            if(bucket.getId() == id)
                itemToRemove = bucket;
        }

        dataModels.remove(itemToRemove);
        return ResponseEntity.ok(dataModels);
    }
}

