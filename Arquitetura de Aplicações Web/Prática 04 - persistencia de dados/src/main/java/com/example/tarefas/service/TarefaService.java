package com.example.tarefas.service;

import  java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarefas.model.tarefa;
import com.example.tarefas.repository.TarefaRepository;

import jakarta.validation.Valid;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<tarefa> listar() {
        return tarefaRepository.findAll();
    }

    public tarefa criar(@Valid tarefa tarefa) {
        tarefa.setDataCriacao(java.time.LocalDateTime.now());
        return tarefaRepository.save(tarefa);
    }

    public tarefa atualizar(Long id, @Valid tarefa tarefaAtualizada) {
        Optional<tarefa> tarefaOptional = tarefaRepository.findById(id); // Correção aqui
        if (tarefaOptional.isEmpty()) {
            throw new RuntimeException("Tarefa não encontrada!");
        }
        tarefa tarefa = tarefaOptional.get();
        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        tarefa.setStatus(tarefaAtualizada.getStatus());
        return tarefaRepository.save(tarefa);
    }

    public void excluir(Long id) {
        tarefaRepository.deleteById(id);
    }
}