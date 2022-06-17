package com.idat.EC2LuisMongeBodega.service;

import java.util.List;

import com.idat.EC2LuisMongeBodega.dto.ProductoDTORequest;
import com.idat.EC2LuisMongeBodega.dto.ProductoDTOResponse;

public interface ProductoServicio {
	
	public void guardarProducto(ProductoDTORequest producto);
	public void editarProducto(ProductoDTORequest producto);
	public void eliminarProducto(Integer id);
	public List<ProductoDTOResponse> listarProductos();
	public ProductoDTOResponse obtenerProductoId(Integer id);

}
