package fiap.com.br.automax.service;

import fiap.com.br.automax.dto.CarroDTO;
import fiap.com.br.automax.entity.Carro;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import fiap.com.br.automax.repository.CarroRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarroService {
    private final CarroRepository repository;

    private CarroDTO convertToDTO(Carro carro) {
        CarroDTO dto = new CarroDTO();
        dto.setId(carro.getId());
        dto.setModelo(carro.getModelo());
        dto.setDatavenda(carro.getDatavenda());
        dto.setPreco(carro.getPreco());
        return dto;
    }

    private Carro convertToEntity(CarroDTO dto){
        Carro carro = new Carro();
        carro.setId(dto.getId());
        carro.setModelo(dto.getModelo());
        carro.setPreco(dto.getPreco());
        carro.setDatavenda(dto.getDatavenda());
        return carro;
    }

    public CarroDTO save(CarroDTO carroDTO){
        Carro carro = convertToEntity(carroDTO);
        carro = (Carro) repository.save(carro);
        return convertToDTO(carro);
    }

    public List<CarroDTO> getCarro(){
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

    public CarroDTO findById(Long id) {
        Optional<Carro> byId = repository.findById(id);
        if (byId.isPresent()){
            return convertToDTO(byId.get());
        }
        throw new RuntimeException("Carro com id " + id + " não encontrado.");
    }
}
