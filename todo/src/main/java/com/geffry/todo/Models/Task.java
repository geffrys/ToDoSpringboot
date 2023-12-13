package com.geffry.todo.Models;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descripcion;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column(name = "fecha_estimada")
    private LocalDateTime fechaEstimada;
    @Column
    private Boolean finalizada;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;
}
