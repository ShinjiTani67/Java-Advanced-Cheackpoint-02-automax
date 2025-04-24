package service;

import dto.VendedorDTO;
import entity.Vendedor;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.VendedorRepository;
import repository.VendendorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VendedorService {
    private final VendendorRepository repository;

    private VendedorDTO convertToDTO(Vendedor vendedor) {
        VendedorDTO dto = new VendedorDTO();
        dto.setId(vendedor.getId());
        dto.setNome(vendedor.getNome());
        dto.setSalario(vendedor.getSalario());
        dto.setDataAdmissao(vendedor.getDataAdmissao());
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
        return convertToDTO(vendendor);
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
