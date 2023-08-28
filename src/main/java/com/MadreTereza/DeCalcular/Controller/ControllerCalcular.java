package com.MadreTereza.DeCalcular.Controller;

import org.springframework.stereotype.Controller;
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

    @GetMapping("/calcula")
    public String getCalculadora() {
        return "telacalculo/TemplateCalculo";
    }

    @PostMapping("/")
    public String postCalculo(@RequestParam("numerin") double numerin,
                              @RequestParam("selecao") String operacao,
                              @RequestParam("numerinDois") String numerinDoisStr,
                              RedirectAttributes redirectAttributes){
        double calculinho = 0;
        double numerinDois = 0;
        if (numerinDoisStr != null && !numerinDoisStr.equals("")){
            numerinDois = Double.parseDouble(numerinDoisStr);
        }

        if (operacao.equals("+")){
            calculinho = numerin + numerinDois;
            redirectAttributes.addFlashAttribute("calculinho", numerin + " + " + numerinDois + " = " + calculinho);
        } else if (operacao.equals("-")){
            calculinho = numerin - numerinDois;
            redirectAttributes.addFlashAttribute("calculinho", numerin + " - " + numerinDois + " = " + calculinho);
        } else if (operacao.equals("*")){
            calculinho = numerin * numerinDois;
            redirectAttributes.addFlashAttribute("calculinho", numerin + " * " + numerinDois + " = " + calculinho);
        } else if (operacao.equals("/")){
            calculinho = numerin / numerinDois;
            redirectAttributes.addFlashAttribute("calculinho", numerin + " / " + numerinDois + " = " + calculinho);
        } else if (operacao.toUpperCase().equals("R")){
            calculinho = Math.sqrt(numerin);
            redirectAttributes.addFlashAttribute("calculinho", "√" + numerin + " = " + calculinho);
        } else if (operacao.toUpperCase().equals("P")){
            calculinho = Math.pow(numerin, numerinDois);
            redirectAttributes.addFlashAttribute("calculinho", numerin + "x^" + numerinDois + " = " + calculinho);
        }
        return "redirect:/calcula";
    }
}
