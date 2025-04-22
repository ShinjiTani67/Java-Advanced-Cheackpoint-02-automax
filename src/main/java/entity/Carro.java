package entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;

@Entity
@Data
@ToString
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;

    @Column(name="modelo",length = 100, nullable = false)
    private String modelo;

    @Column(name="preco",length = 100, nullable = false)
    private double preco;

    @DateTimeFormat
    private int datavenda;

}
