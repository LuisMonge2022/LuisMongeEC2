package com.idat.EC2LuisMongeBodega.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Productos")
@Entity
public class Productos implements Serializable {
		
	
	private static final long serialVersionUID = -1529965669649986222L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	private String producto;
	private String descripcion;
	private String precio;
	private Integer stock;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "producto_cliente",			
			joinColumns = 
			@JoinColumn(name = "id_cliente", 
			nullable = false, 
			unique = true, 
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references Clientes (id_cliente)")),
	
	inverseJoinColumns = 
			@JoinColumn(name = "id_producto", 
			nullable = false, 
			unique = true, 
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references Productos (id_producto)"))
	)
	private List<Cliente> cliente = new ArrayList<Cliente>();
	
	@OneToMany(mappedBy = "producto")
	private List<Bodega> Bodega = new ArrayList<Bodega>();
	
	
			
	public Productos() {
		super();
		
	}
	public Productos(Integer idProducto, String producto, String descripcion, String precio, Integer stock) {
		super();
		this.idProducto = idProducto;
		this.producto = producto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	

}
