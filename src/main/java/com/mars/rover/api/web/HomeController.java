package com.mars.rover.api.web;

import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.mars.rover.api.dto.HomeDto;
import com.mars.rover.api.response.MarsRoverApiResponse;
import com.mars.rover.api.service.MarsRoverApiService;
@Controller
public class HomeController {

  @Autowired
  private MarsRoverApiService roverService;
  
  @SuppressWarnings("deprecation")
@GetMapping("/")
  public String getHomeView (ModelMap model, HomeDto homeDto) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    // if request param is empty, then set a default value
    if (StringUtils.isEmpty(homeDto.getMarsApiRoverData())) {
      homeDto.setMarsApiRoverData("Opportunity");
    }
    if (homeDto.getMarsSol() == null)
      homeDto.setMarsSol(1);
    
    MarsRoverApiResponse roverData = roverService.getRoverData(homeDto);
    model.put("roverData", roverData);
    model.put("homeDto", homeDto);
    model.put("validCameras", roverService.getValidCameras().get(homeDto.getMarsApiRoverData()));
    
    return "index";
  }
  
}
