package service;

import dto.VendedorDTO;
import entity.Vendedor;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.VendedorRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VendedorService {
    private final VendedorRepository repository;

    private VendedorDTO convertToDTO(Vendedor vendedor) {
        VendedorDTO dto = new VendedorDTO();
        dto.setId(vendedor.getId());
        dto.setNome(vendedor.getNome());
        dto.setSalario(vendedor.getSalario());
        dto.setDataadmissao(vendedor.getDataadmissao());
        return dto;
    }

    private Vendedor convertToEntity(VendedorDTO dto){
        Vendedor vendedor = new Vendedor();
        vendedor.setId(dto.getId());
        vendedor.setNome(dto.getNome());
        vendedor.setSalario(dto.getSalario());
        vendedor.setDataadmissao(dto.getDataadmissao());
        return vendedor;
    }

    public VendedorDTO save(@Valid VendedorDTO vendedorDTO){
        Vendedor vendedor = convertToEntity(vendedorDTO);
        vendedor = repository.save(vendedor);
        return convertToDTO(vendedor);
    }

    public List<VendedorDTO> getVendedores(){
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

    public VendedorDTO findById(Long id) {
        Optional<Vendedor> byId = repository.findById(id);
        if (byId.isPresent()){
            return convertToDTO(byId.get());
        }
        throw new RuntimeException("Vendedor com id " + id + " não encontrado.");
    }
}
