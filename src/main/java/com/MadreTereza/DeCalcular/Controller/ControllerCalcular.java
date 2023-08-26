package com.MadreTereza.DeCalcular.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerCalcular {

    @GetMapping("/")
    public String landPage() {
        return "telacalculo/TemplateCalculo";
    }

    @PostMapping("/")
    public String postCalculo(@RequestParam("numerin") String numerin,
                                Model model){
        double calculinho = Math.pow(Double.valueOf(numerin), 2);

        model.addAttribute("calculinho", numerin + "² = " + calculinho);
        return "telacalculo/TemplateCalculo";
    }
}
