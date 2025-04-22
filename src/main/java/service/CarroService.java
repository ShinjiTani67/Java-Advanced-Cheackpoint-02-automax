package service;

import dto.CarroDTO;
import entity.Carro;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.CarroRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarroService {
    private final CarroRepository repository;

    private CarroDTO convertToDTO(Carro carro) {
        CarroDTO dto = new CarroDTO();
        dto.setUuid(carro.getUuid());
        dto.setModelo(carro.getModelo());
        dto.setDatavenda(carro.getDatavenda());
        dto.setPreco(carro.getPreco());
        return dto;
    }

    private Carro convertToEntity(CarroDTO dto){
        Carro carro = new Carro();
        carro.setUuid(dto.getUuid());
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
}
