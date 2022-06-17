package com.idat.EC2LuisMongeBodega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2LuisMongeBodega.dto.UsuarioDTORequest;
import com.idat.EC2LuisMongeBodega.dto.UsuarioDTOResponse;
import com.idat.EC2LuisMongeBodega.modelo.Usuario;
import com.idat.EC2LuisMongeBodega.repositorio.UsuarioRepositorio;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	
	
	@Autowired
	public UsuarioRepositorio repositorio;
	
	@Override
	public void guardarUsuario(UsuarioDTORequest usuario) {
		
		Usuario u = new Usuario();
		u.setIdUsuario(usuario.getIdUsuarioDTO());
		u.setUsuario(usuario.getUsuarioDTO());
		u.setContrasenia(usuario.getContraseniaDTO());
		u.setRol(usuario.getRolDTO());		
		
		repositorio.save(u);
		
	}

	@Override
	public void editarUsuario(UsuarioDTORequest usuario) {
		
		Usuario u = new Usuario();
		u.setIdUsuario(usuario.getIdUsuarioDTO());
		u.setUsuario(usuario.getUsuarioDTO());
		u.setContrasenia(usuario.getContraseniaDTO());
		u.setRol(usuario.getRolDTO());			
		
		repositorio.saveAndFlush(u);
		
	}

	@Override
	public void eliminarUsuario(Integer id) {
		
		repositorio.deleteById(id);
		
	}

	@Override
	public List<UsuarioDTOResponse> listarUsuarios() {
		List<UsuarioDTOResponse> lista = new ArrayList<UsuarioDTOResponse>();
		UsuarioDTOResponse u = null;	
		
		
		for (Usuario usuario : repositorio.findAll()) {
			u = new UsuarioDTOResponse();
			
			u.setIdUsuarioDTO(usuario.getIdUsuario());
			u.setUsuarioDTO(usuario.getUsuario());
			u.setContraseniaDTO(usuario.getContrasenia());
			u.setRolDTO(usuario.getRol());
			
			lista.add(u);
			
		}
		
		return lista;
		
	}

	@Override
	public UsuarioDTOResponse obtenerUsuarioId(Integer id) {
		
		Usuario usuario = repositorio.findById(id).orElse(null);
		
		UsuarioDTOResponse u = new UsuarioDTOResponse();
		
		u.setIdUsuarioDTO(usuario.getIdUsuario());
		u.setUsuarioDTO(usuario.getUsuario());
		u.setContraseniaDTO(usuario.getContrasenia());
		u.setRolDTO(usuario.getRol());			
		
		return u;
	}
}
	
