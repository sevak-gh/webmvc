package sevak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @RequestMapping(value="/signin", method=RequestMethod.GET)
    public String login(@RequestParam(value="error", required=false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "true");
        }
        model.addAttribute("targetUrl", "/err");
        return "login";
    }

    @RequestMapping(value="/logintest", method=RequestMethod.GET)
    @ResponseBody
    public String logintest(Model model) {
        return "login test...";
    }

    @RequestMapping(value="/signout", method=RequestMethod.GET)
    public String logout(Model model) {
        model.addAttribute("logout", "true");
        return "login";
    }
}
