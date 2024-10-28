package com.example.inventory_service.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@Table( name = "t_inventory")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Long id;
    String itemCode;
    Integer quantity;

}
