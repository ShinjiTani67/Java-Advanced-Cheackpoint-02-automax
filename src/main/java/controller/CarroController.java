package controller;

import dto.CarroDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import service.CarroService;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/carro")
public class CarroController {

    private final CarroService service;

    @GetMapping
    public String listarCarro(Model model) {
        model.addAttribute("carro", service.getCarro());
        return "template.carro/lista";
    }

    @GetMapping("/novo")
    public String novoCarro(Model model){
        model.addAttribute("carro", new CarroDTO());
        return "carro/formulario";
    }

    @PostMapping("/salvar")
    public String salvarCarro(
            @Valid @ModelAttribute("carro") CarroDTO carroDTO,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            log.warn("Erros de validação ao salvar carro:");
            bindingResult.getAllErrors().forEach(e -> log.warn(e.toString()));
            model.addAttribute("carro", carroDTO);
            return "carro/formulario";
        }
        log.info("Salvando carro: {}", carroDTO);
        service.save(carroDTO);
        return "redirect:/carro";
    }

    @GetMapping("/editar/{id}")
    public String deletar(@PathVariable Long id){
        service.deletarPorId(id);
        return "redirect:/carro";
    }
}