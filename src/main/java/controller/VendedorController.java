package controller;

import dto.VendedorDTO;
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
        model.addAttribute("template.vendedor", new VendedorDTO());
        return "template.vendedor/formulario";
    }

    @PostMapping("/salvar")
    public String salvarVendedor(
            @Valid @ModelAttribute("template.vendedor") VendedorDTO vendedorDTO,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            log.warn("Erros de validação ao salvar vendedor:");
            bindingResult.getAllErrors().forEach(e -> log.warn(e.toString()));
            model.addAttribute("vendedor", vendedorDTO);
            return "vendedor/formulario";
        }
        service.save(vendedorDTO);
        log.info("Salvando vendedor: {}", vendedorDTO);
        return "redirect:/vendedor";
    }

    @GetMapping("/editar/{id}")
    public String deletar(@PathVariable Long id){
        service.deletarPorId(id);
        return "redirect:/vendedor";
    }
}
