package us.rbirm.passerine;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {


  @MessageMapping("/hello")
  @SendTo("/topic/test")
  public Messenger messenger(TestMessage message) throws Exception {
    Thread.sleep(1000); // simulated delay
    return new Messenger("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
  }

}
