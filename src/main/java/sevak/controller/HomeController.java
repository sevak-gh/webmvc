package sevak.controller;

import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(Model model) {
        model.addAttribute("message", "this is my home page");
        return "forward:/forward";
    }

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "this is my home page");
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value="/err", method = RequestMethod.GET)
    @ResponseBody
    //public String error(Model model) throws HttpMediaTypeNotAcceptableException {
    public String error(Model model) {
        //throw new HttpMediaTypeNotAcceptableException("oh my god!!!");
        throw new RuntimeException("oh my god!!!");
        //return "error page";
    }

    @RequestMapping(value="/what", method = RequestMethod.GET)
    public String askWhat(Model model) {
        model.addAttribute("message", "what is your name");
        return "index";
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(Model model) {
        return "hi everybody...";
    }

    @RequestMapping(value="/forward", method = RequestMethod.GET)
    public String printWelcomeForward(Model model) {
        model.addAttribute("note", "came by forward");
        return "index";
    }

    @RequestMapping(value="/json", method = RequestMethod.GET, produces={"application/json"})
    @ResponseBody
    public Map<String, String> getJson() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "sevak");
        map.put("hobby", "music");
        return map;
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleError(HttpServletRequest request, RuntimeException e) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("e", e);
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String processInfo(@RequestParam("info") String param) {
        return "your message: " + param;
    }
}
