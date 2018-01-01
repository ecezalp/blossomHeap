package ozalp.restfulflower.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ozalp.restfulflower.domain.welcome.Greeting;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/api")
public class GreetingsController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping(method = RequestMethod.GET, value = "/greetings")
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    return new Greeting(counter.incrementAndGet(),
      String.format(template, name));
  }
}