package service;

import dto.VendedorDTO;
import dto.VendendorDTO;
import entity.Vendedor;
import entity.Vendendor;
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

    private VendedorDTO convertToDTO(Vendendor vendendor) {
        VendedorDTO dto = new VendedorDTO();
        dto.setId(vendendor.getId());
        dto.setNome(vendendor.getNome());
        dto.setSalario(vendendor.getSalario());
        dto.setDataAdmissao(vendendor.getDataAdmissao());
        return dto;
    }

    private Vendendor convertToEntity(VendendorDTO dto){
        Vendendor vendendor = new Vendendor();
        vendendor.setId(dto.getId());
        vendendor.setNome(dto.getNome());
        vendendor.setSalario(dto.getSalario());
        vendendor.setDataadmissao(dto.getDataadmissao());
        return vendendor;
    }

    public VendedorDTO save(@Valid VendendorDTO vendedorDTO){
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
