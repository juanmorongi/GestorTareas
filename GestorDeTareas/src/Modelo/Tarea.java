package Modelo;
import java.sql.SQLException;
import java.util.*;

import DAO.*;

public class Tarea {

	private int id;
	private int pid;
	private String nombre;
	private String descripcion;
	private int categoria;
	private int estado;
	private String fechaIni;
	private String fechaFin;
	private int importancia;
	
	public Tarea() {
		this.estado=0;
		this.nombre="";
		this.descripcion="";
		this.fechaFin="";
		this.fechaIni="";
	}
	
	public Tarea(int pid, String nombre, String descripcion, int categoria, int estado, String fechaIni, String fechaFin, int importancia) {
		this.pid = pid;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.estado = estado;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.importancia = importancia;
	}
	
	public Tarea(int id, int pid, String nombre, String descripcion, int categoria, int estado, String fechaIni, String fechaFin, int importancia) {
		this.id = id;
		this.pid = pid;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.estado = estado;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.importancia = importancia;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getCategoria() {
		return this.categoria;
	}
	
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public String getFechaIni() {
		return fechaIni;
	}
	
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	
	public String getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public int getImportancia() {
		return importancia;
	}
	
	public void setImportancia(int importancia) {
		this.importancia = importancia;
	}
	
	public void insertar() {
		try {
			DAOTarea.getInstance().insert(this);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actualizar() {
		try {
			DAOTarea.getInstance().update(this);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "Tarea [pid=" + pid + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria
				+ ", estado=" + estado + ", importancia=" + importancia + "]\n";
	}
	
	
	
	
}
