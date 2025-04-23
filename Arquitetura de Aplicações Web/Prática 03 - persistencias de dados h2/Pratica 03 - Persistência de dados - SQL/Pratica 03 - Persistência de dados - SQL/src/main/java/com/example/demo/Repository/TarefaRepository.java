package com.example.demo.Repository;

import com.example.demo.Model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    //JpaRepository ja tem metodos prontos findAll(),save()
}
