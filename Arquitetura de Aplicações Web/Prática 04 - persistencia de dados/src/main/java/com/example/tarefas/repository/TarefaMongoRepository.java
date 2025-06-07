package com.example.tarefas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.tarefas.model.tarefa;

public interface TarefaMongoRepository extends MongoRepository<tarefa, String> {}
