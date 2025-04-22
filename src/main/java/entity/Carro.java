package entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
public class Carro {

    UUID uuid;
    String modelo;
    
}
