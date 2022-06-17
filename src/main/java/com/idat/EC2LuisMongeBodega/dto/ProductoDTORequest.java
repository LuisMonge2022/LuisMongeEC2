package com.idat.EC2LuisMongeBodega.dto;

public class ProductoDTORequest {
	
	private Integer idProductoDTO;	
	private String productoDTO;
	private String descripcionDTO;
	private String precioDTO;
	private Integer stockDTO;
	
	
	public Integer getIdProductoDTO() {
		return idProductoDTO;
	}
	public void setIdProductoDTO(Integer idProductoDTO) {
		this.idProductoDTO = idProductoDTO;
	}
	public String getProductoDTO() {
		return productoDTO;
	}
	public void setProductoDTO(String productoDTO) {
		this.productoDTO = productoDTO;
	}
	public String getDescripcionDTO() {
		return descripcionDTO;
	}
	public void setDescripcionDTO(String descripcionDTO) {
		this.descripcionDTO = descripcionDTO;
	}
	public String getPrecioDTO() {
		return precioDTO;
	}
	public void setPrecioDTO(String precioDTO) {
		this.precioDTO = precioDTO;
	}
	public Integer getStockDTO() {
		return stockDTO;
	}
	public void setStockDTO(Integer stockDTO) {
		this.stockDTO = stockDTO;
	}
		
	
	

}
