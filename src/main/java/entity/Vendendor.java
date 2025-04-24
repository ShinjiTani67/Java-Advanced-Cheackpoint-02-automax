package entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@ToString
public class Vendendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="modelo",length = 100, nullable = false)
    private String nome;

    @Column(name="preco",length = 100, nullable = false)
    private double salario;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataadmissao;

}
