package edu.tienda.core.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;
    private Integer stock;


}
