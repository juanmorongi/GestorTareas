package Modelo;

import DAO.DAOTarea;
import java.util.ArrayList;

public class ListaTareas {

	private ArrayList<Tarea> lista;
	
	public ListaTareas() {
		
	}
	
	public String imprimirLista() {
		String txt="<table class='table table-dark'>";
		for(Tarea t: lista) {
			txt+= "<tr><td>Tarea "+t.getId()+"</td><td>"+t.getNombre()+"</td><td><a href='editarTarea.jsp?id="+t.getId()+"'>Editar</a></td><td><a href='eliminarTarea.jsp?id="+t.getId()+"'>Eliminar</a></td></tr>";
		}
		return txt+"</table>";
	}
	
	public void obtener() {
		try {
			lista = DAOTarea.getInstance().listaTareas();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Tarea getTareaById(int id){
		Tarea tarea = null;
		for(Tarea t: lista){
			if(t.getId() == id)
				tarea = t;
		}
		return tarea;
	}
	
	public void eliminar(int id){
		try {
			DAOTarea.getInstance().delete(id);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
