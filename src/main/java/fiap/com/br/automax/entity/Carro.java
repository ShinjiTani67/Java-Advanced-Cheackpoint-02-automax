package fiap.com.br.automax.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@ToString
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="modelo",length = 100, nullable = false)
    private String modelo;

    @Column(name="preco",length = 100, nullable = false)
    private double preco;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datavenda;

}
