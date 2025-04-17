package ControleAcesso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ControleAcesso.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

}
