package ozalp.restfulflower.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

  @RequestMapping(value = "/")
  public String index() {
    return "index.html";
  }
}