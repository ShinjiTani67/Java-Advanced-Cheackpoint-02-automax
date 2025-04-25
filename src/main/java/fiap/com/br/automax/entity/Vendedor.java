package fiap.com.br.automax.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@ToString
public class Vendedor {

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
