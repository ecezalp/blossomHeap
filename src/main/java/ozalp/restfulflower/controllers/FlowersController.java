package ozalp.restfulflower.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ozalp.restfulflower.domain.Flower;
import ozalp.restfulflower.repositories.FlowerRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlowersController {

  @Autowired
  FlowerRepository flowerRepository;

  @RequestMapping(method = RequestMethod.GET, value = "/flowers")
  public List<Flower> index() {
    return flowerRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/flowers/new")
  public Flower create(Flower flower) {
    return flowerRepository.create(flower);
  }
}
