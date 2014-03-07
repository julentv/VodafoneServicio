package pr.vodafone.service;

import java.sql.SQLException;

import pr.vodafone.dao.GestorBD;
import pr.vodafone.dao.dto.Terminal;

public class ServiceProvider {

	public Terminal obtenerTerminal(String idTerminal){
		GestorBD gestorBD = new GestorBD();
		Terminal terminal= null;
		try {
			gestorBD.conectar();
			terminal= gestorBD.obtenerTerminal(idTerminal);
			gestorBD.desconectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return terminal;
		
	}
	
	public Terminal[] obtenerTerminales(){
		GestorBD gestorBD = new GestorBD();
		Terminal terminal[]= null;
		try {
			gestorBD.conectar();
			terminal= (Terminal[]) gestorBD.obtenerTerminales().toArray();
			gestorBD.desconectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return terminal;
	}
	
	public Terminal[] obtenerTerminalesPorMarca(String marca){
		GestorBD gestorBD = new GestorBD();
		Terminal terminal[]= null;
		try {
			gestorBD.conectar();
			terminal= (Terminal[]) gestorBD.obtenerTerminalesPorMarca(marca).toArray();
			gestorBD.desconectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return terminal;
	}
	
	public boolean insertarTerminal(Terminal terminal){
		GestorBD gestorBD = new GestorBD();
		boolean terminalInsertado= false;
		try {
			gestorBD.conectar();
			gestorBD.insertarTerminal(terminal);
			terminalInsertado=true;
			gestorBD.desconectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return terminalInsertado;
	}
	
	public boolean actualizarTerminal(String idTerminal, Terminal terminal){
		GestorBD gestorBD = new GestorBD();
		boolean terminalActualizado= false;
		try {
			gestorBD.conectar();
			gestorBD.actualizarTerminal(idTerminal, terminal);
			terminalActualizado=true;
			gestorBD.desconectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return terminalActualizado;
	}
	
	public boolean borrarTerminal(String idTerminal){
		GestorBD gestorBD = new GestorBD();
		boolean terminalBorrado= false;
		try {
			gestorBD.conectar();
			gestorBD.borrarTerminal(idTerminal);
			terminalBorrado=true;
			gestorBD.desconectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return terminalBorrado;
	}
}

