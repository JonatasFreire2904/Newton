package com.example.tarefas.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tarefas.model.tarefa;

public interface TarefaRepository extends JpaRepository<tarefa,Long> {}
