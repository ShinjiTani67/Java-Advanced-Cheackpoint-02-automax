package controller;


import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CarroService;

@Controller
@AllArgsConstructor
@Log
@RequestMapping("/carro")
public class CarroController {

    private final CarroService service;

}
