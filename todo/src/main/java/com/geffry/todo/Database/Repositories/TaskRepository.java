package com.geffry.todo.Database.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.geffry.todo.Database.Models.Estado;
import com.geffry.todo.Database.Models.Task;

import java.time.LocalDateTime;



public interface TaskRepository extends ListCrudRepository<Task, Integer>{
    List<Task> findAll();
    Optional<Task> findById(Integer id);
    List<Task> findByEstado(Estado estado);
    List<Task> findByFinalizada(Boolean finalizada);
    List<Task> findByTitulo(String titulo);
    List<Task> findByDescripcion(String descripcion);
    List<Task> findByFechaCreacion(LocalDateTime fechaCreacion);
    @Modifying
    @Query(value = "UPDATE tasks SET finalizada=1 WHERE id=:id",nativeQuery = true)
    void markTaskAsFinished(@Param("id") Integer id);
}
