package service;

import dto.CarroDTO;
import entity.Carro;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.CarroRepository;
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
        return carro;
    }

    public CarroDTO save(CarroDTO carroDTO){
        Carro carro = convertToEntity(carroDTO);
        carro = (Carro) repository.save(carro);
        return convertToDTO(carro);
    }

    public List<CarroDTO> getCarro(){
        List<CarroDTO> carro = repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return carro;
    }
    public void deletarPorId(Id id) {
        repository.deleteById(id);
}

    public CarroDTO findById(Long id) {
        Optional<Carro> byUuid = repository.findById(id);
        if (findById().isPresent()){
            return convertToDTO(byId.get());
        }
        throw new RuntimeException("id not found");
    }
}
