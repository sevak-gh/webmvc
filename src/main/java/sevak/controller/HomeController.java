package sevak.controller;

import sevak.exception.CustomException;
import sevak.exception.MyException;

import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class HomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String printWelcome(Model model) {
        model.addAttribute("message", "this is my home page");
        return "forward:/forward";
    }

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(HttpSession session) {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "this is my home page");
        model.addObject("id", session.getId());
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value="/err", method = RequestMethod.GET)
    @ResponseBody
    //public String error(Model model) throws HttpMediaTypeNotAcceptableException {
    public String error(Model model) {
        //throw new HttpMediaTypeNotAcceptableException("oh my god!!!");
        //throw new RuntimeException("oh my god!!!");
        throw new CustomException("oh my god!!!");
        //return "error page";
    }

    @RequestMapping(value="/rre", method = RequestMethod.GET)
    public void rre() {
        throw new MyException("oh my goodness!!!");
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

    @ExceptionHandler(CustomException.class)
    public ModelAndView handleError(HttpServletRequest request, CustomException e) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("e", e);
        return model;
    }
/*
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String processInfo(@RequestParam("info") String param) {
        return "your message: " + param;
    }
*/
}
