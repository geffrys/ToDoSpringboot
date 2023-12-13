package com.geffry.todo.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.geffry.todo.Models.Task;
import com.geffry.todo.Models.Estado;
import java.time.LocalDateTime;



public interface TaskRepository extends ListCrudRepository<Task, Integer>{
    List<Task> findAll();
    Optional<Task> findById(Integer id);
    List<Task> findByEstado(Estado estado);
    List<Task> findByFinalizada(Boolean finalizada);
    List<Task> findByTitulo(String titulo);
    List<Task> findByDescripcion(String descripcion);
    List<Task> findByFechaCreacion(LocalDateTime fechaCreacion);
}
