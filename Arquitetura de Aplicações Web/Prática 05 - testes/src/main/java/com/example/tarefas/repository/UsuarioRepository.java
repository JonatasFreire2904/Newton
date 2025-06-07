package com.example.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tarefas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
