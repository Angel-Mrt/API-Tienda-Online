package edu.tienda.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    private Integer id;
    private  String nombre;
    private String password;
    private String username;

}
