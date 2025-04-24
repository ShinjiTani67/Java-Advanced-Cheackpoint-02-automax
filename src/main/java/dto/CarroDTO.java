package dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarroDTO {

    private long id;

    private String modelo;

    private double preco;

    private int datavenda;

}
