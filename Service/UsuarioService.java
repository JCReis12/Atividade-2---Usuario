package ControleAcesso.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ControleAcesso.Entities.Usuario;
import ControleAcesso.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario saveUsuario (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario getUsuarioById (Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public List<Usuario> getAllUsuario(){
		return usuarioRepository.findAll();
	}
	
	public Usuario alteraUsuario (Long id, Usuario alteraUsuario) {
		Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
		if(existeUsuario.isPresent()) {
			alteraUsuario.setId(id);
			return usuarioRepository.save(alteraUsuario);
		}
		else {
			return null;
		}
	}
	
	public boolean deleteUsuario (Long id) {
		Optional <Usuario> existeUsuario = usuarioRepository.findById(id);
		if(existeUsuario.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	

}
