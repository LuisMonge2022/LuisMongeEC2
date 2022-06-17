package com.idat.EC2LuisMongeBodega.service;

import java.util.List;

import com.idat.EC2LuisMongeBodega.dto.UsuarioDTORequest;
import com.idat.EC2LuisMongeBodega.dto.UsuarioDTOResponse;

public interface UsuarioServicio {
	
	public void guardarUsuario(UsuarioDTORequest usuario);
	public void editarUsuario(UsuarioDTORequest usuario);
	public void eliminarUsuario(Integer id);
	public List<UsuarioDTOResponse> listarUsuarios();
	public UsuarioDTOResponse obtenerUsuarioId(Integer id);

}
