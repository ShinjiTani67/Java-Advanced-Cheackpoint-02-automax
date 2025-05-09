package fiap.com.br.automax.controller;

import fiap.com.br.automax.dto.VendedorDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import fiap.com.br.automax.service.VendedorService;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/vendedor")
public class VendedorController {

    private final VendedorService service;

    @GetMapping
    public String listarVendedor(Model model) {
        model.addAttribute("vendedor", service.getVendedores());
        return "vendedor/lista";
    }

    @GetMapping("/novo")
    public String novoVendedor(Model model){
        model.addAttribute("vendedor", new VendedorDTO());
        return "vendedor/formulario";
    }

    @PostMapping("/salvar")
    public String salvarVendedor(
            @Valid @ModelAttribute("vendedor") VendedorDTO vendedorDTO,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            log.warn("Erros de validacao ao salvar vendedor:");
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
