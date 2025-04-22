package controller;


import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import service.CarroService;

@Controller
@AllArgsConstructor
@Log
@RequestMapping("/carro")
public class CarroController {

    private final CarroService service;
    @GetMapping
    public String listarCarros(Model model) {
        model.addAttribute("carro", service.getCarro());
        return "carro/lista";
    }
}
