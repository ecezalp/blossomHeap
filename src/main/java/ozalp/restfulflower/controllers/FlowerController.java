package ozalp.restfulflower.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ozalp.restfulflower.domain.Flower;
import ozalp.restfulflower.repositories.FlowerRepository;

@RestController
public class FlowerController {

  @Autowired
  FlowerRepository flowerRepository;

  @RequestMapping("/save")
  public String process(){
    flowerRepository.save(Flower.builder().id(1).color("yellow").border("4px").build());
    flowerRepository.save(Flower.builder().id(2).color("green").border("1px").build());
    flowerRepository.save(Flower.builder().id(3).color("blue").border("2px").build());
    flowerRepository.save(Flower.builder().id(4).color("emerald").border("2px").build());
    flowerRepository.save(Flower.builder().id(5).color("purple").border("6px").build());
    return "Done";
  }


  @RequestMapping("/findall")
  public String findAll(){
    String result = "<html>";

    for(Flower cust : flowerRepository.findAll()){
      result += "<div>" + cust.toString() + "</div>";
    }

    return result + "</html>";
  }

  @RequestMapping("/findbyid")
  public String findById(@RequestParam("id") long id){
    String result = "";
    result = flowerRepository.findOne(id).toString();
    return result;
  }

  @RequestMapping("/findbycolor")
  public String fetchDataByColor(@RequestParam("color") String color){
    String result = "<html>";

    for(Flower cust: flowerRepository.findByColor(color)){
      result += "<div>" + cust.toString() + "</div>";
    }

    return result + "</html>";
  }


}
