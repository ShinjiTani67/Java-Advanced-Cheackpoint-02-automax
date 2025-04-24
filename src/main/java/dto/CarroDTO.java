package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarroDTO {

    private long id;

    private String modelo;

    private double preco;

    private LocalDate datavenda;

}
