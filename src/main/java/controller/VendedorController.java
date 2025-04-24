package controller;

import dto.VendendorDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import service.VendedorService;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/template.vendedor")
public class VendedorController {

    private final VendedorService service;

    @GetMapping
    public String listarVendedor(Model model) {
        model.addAttribute("template.vendedor", service.getVendedores());
        return "template.vendedor/lista";
    }

    @GetMapping("/novo")
    public String novoVendedor(Model model){
        model.addAttribute("template.vendedor", new VendendorDTO());
        return "template.vendedor/formulario";
    }

    @PostMapping("/salvar")
    public String salvarVendedor(
            @Valid @ModelAttribute("template.vendedor") VendendorDTO vendedorDTO,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> log.info(e.toString()));
            model.addAttribute("template.vendedor", vendedorDTO);
            return "template.vendedor/formulario";
        }
        service.save(vendedorDTO);
        return "redirect:/vendedor";
    }

    @GetMapping("/editar/{id}")
    public String deletar(@PathVariable Long id){
        service.deletarPorId(id);
        return "redirect:/vendedor";
    }
}
