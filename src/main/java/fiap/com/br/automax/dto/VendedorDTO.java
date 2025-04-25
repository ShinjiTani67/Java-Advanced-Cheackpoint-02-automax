package fiap.com.br.automax.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendedorDTO {
    private long id;

    private String nome;

    private double salario;

    private LocalDate dataadmissao;
}
