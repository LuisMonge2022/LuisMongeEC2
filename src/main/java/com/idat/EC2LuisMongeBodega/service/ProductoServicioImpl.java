package com.idat.EC2LuisMongeBodega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2LuisMongeBodega.dto.ProductoDTORequest;
import com.idat.EC2LuisMongeBodega.dto.ProductoDTOResponse;
import com.idat.EC2LuisMongeBodega.modelo.Productos;
import com.idat.EC2LuisMongeBodega.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio {

	@Autowired
	public ProductoRepositorio repositorio;

	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		Productos p = new Productos();
		p.setIdProducto(producto.getIdProductoDTO());
		p.setProducto(producto.getProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		
		repositorio.save(p);
		
	}

	@Override
	public void editarProducto(ProductoDTORequest producto) {
		Productos p = new Productos();
		p.setIdProducto(producto.getIdProductoDTO());
		p.setProducto(producto.getProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		
		repositorio.saveAndFlush(p);
		
	}

	@Override
	public void eliminarProducto(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<ProductoDTOResponse> listarProductos() {
		List<ProductoDTOResponse> lista = new ArrayList<ProductoDTOResponse>();
		ProductoDTOResponse p = null;	
		
		
		for (Productos producto : repositorio.findAll()) {
			p = new ProductoDTOResponse();
			
			p.setIdProductoDTO(producto.getIdProducto());
			p.setProductoDTO(producto.getProducto());
			p.setDescripcionDTO(producto.getDescripcion());
			p.setPrecioDTO(producto.getPrecio());
			p.setStockDTO(producto.getStock());
			
			lista.add(p);
		}
		
		return lista;
	}

	@Override
	public ProductoDTOResponse obtenerProductoId(Integer id) {
		
		Productos producto = repositorio.findById(id).orElse(null);
		
		ProductoDTOResponse p = new ProductoDTOResponse();
		
		p.setIdProductoDTO(producto.getIdProducto());
		p.setProductoDTO(producto.getProducto());
		p.setDescripcionDTO(producto.getDescripcion());
		p.setPrecioDTO(producto.getPrecio());
		p.setStockDTO(producto.getStock());	
		
		return p;
	}

	
		
	
}