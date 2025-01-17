package vttp5a_paf.day24_25ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vttp5a_paf.day24_25ws.service.RegistrationService;

@Controller
@RequestMapping("")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public ModelAndView showIndexPage() {
        ModelAndView mav = new ModelAndView("index");
        List<String> customerNamesList = registrationService.getRegistrations();
        mav.addObject("names", customerNamesList);

        return mav;
    }
}
