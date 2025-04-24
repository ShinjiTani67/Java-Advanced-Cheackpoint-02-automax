package controller;


import dto.CarroDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import service.CarroService;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/template.carro")
public class CarroController {

    private final CarroService service;

    @GetMapping
    public String listarCarro(Model model) {
        model.addAttribute("template.carro", service.getCarro());
        return "template.carro/lista";
    }

    @GetMapping("/novo")
    public String novoCarro(Model model){
        model.addAttribute("template.carro", new CarroDTO());
        return "template.carro/formulario";
    }
    @PostMapping("/salvar")
    public String salvarCarro(
            @Valid @ModelAttribute("template.carro") CarroDTO carroDTO,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> log.info(e.toString()));
            model.addAttribute("template.carro", carroDTO);
            return "template.carro/formulario";
        }
        service.save(carroDTO);
        return "redirect:/carro";
    }

    @GetMapping("/editar/{id}")
    public String deletar(@PathVariable Long id){
        service.deletarPorId(id);
        return "redirect:/carro";
    }
}