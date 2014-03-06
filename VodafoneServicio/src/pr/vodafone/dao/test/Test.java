package pr.vodafone.dao.test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import pr.vodafone.dao.GestorBD;
import pr.vodafone.dao.dto.Cliente;
import pr.vodafone.dao.dto.Factura;
import pr.vodafone.dao.dto.Linea;
import pr.vodafone.dao.dto.Terminal;


public class Test {

	public void testClientes(){
		GestorBD gbd = new GestorBD();
        try {
			gbd.conectar();
			Cliente cliente = new Cliente ("444", "Asier Perallos", "Calle YYY, Portugalete", "perallos@deusto.es");
			gbd.insertarCliente(cliente);
			cliente = gbd.obtenerCliente("444");
			this.visualizarCliente(cliente);
			
			cliente.setNombre("Asier Perallos Ruiz");
			gbd.actualizarCliente("444", cliente);
			cliente = gbd.obtenerCliente("444");
			this.visualizarCliente(cliente);
			
			gbd.borrarCliente("444");
			
			Vector<Cliente> clientes;
			clientes = gbd.obtenerClientes();
			this.visualizarClientes(clientes);
			
			clientes = gbd.obtenerClientesPorNombre("e");
			this.visualizarClientes(clientes);
			
			int count = gbd.contarClientes();
			System.out.println("Clientes = " + count);
            
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public void testLineas(){
		GestorBD gbd = new GestorBD();
        try {
			gbd.conectar();
			Linea linea = new Linea ("666444000", "2011-03-03", true, "@T", "@M", "Ninguna", "111");
			gbd.insertarLinea(linea);
			linea = gbd.obtenerLinea("666444000");
			this.visualizarLinea(linea);
			
			linea.setPromocion("Todo gratis");
			gbd.actualizarLinea("666444000", linea);
			gbd.activarLinea("666444000", false);
			linea = gbd.obtenerLinea("666444000");
			this.visualizarLinea(linea);
			
			gbd.borrarLinea("666444000");
			
			Vector<Linea> lineas;
			lineas = gbd.obtenerLineas();
			this.visualizarLineas(lineas);
			
			lineas = gbd.obtenerLineasActivas(true);
			this.visualizarLineas(lineas);
			
			lineas = gbd.obtenerLineasCliente("111");
			this.visualizarLineas(lineas);
			
			lineas = gbd.obtenerLineasActivasCliente("111", true);
			this.visualizarLineas(lineas);
			
			int count = gbd.contarLineas();
			System.out.println("Lineas = " + count);
            
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public void testFacturas(){
		GestorBD gbd = new GestorBD();
        try {
			gbd.conectar();
			Factura factura = new Factura ("2011-03-03", "Enero", 300, "666222000");
			gbd.insertarFactura(factura);
			
			factura = gbd.obtenerFactura(1);
			this.visualizarFactura(factura);
			
			factura.setImporte(factura.getImporte() + 10);
			gbd.actualizarFactura(factura.getIdFactura(), factura);
			factura = gbd.obtenerFactura(factura.getIdFactura());
			this.visualizarFactura(factura);
			
			//gbd.borrarFactura(3);
			
			Vector<Factura> facturas;
			facturas = gbd.obtenerFacturas();
			this.visualizarFacturas(facturas);
			
			facturas = gbd.obtenerFacturasLinea("666111000");
			this.visualizarFacturas(facturas);
			
			facturas = gbd.obtenerFacturasCliente("111");
			this.visualizarFacturas(facturas);
						
			int count = gbd.contarFacturas();
			System.out.println("Facturas = " + count);
            
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	public void testTerminales(){
		GestorBD gbd = new GestorBD();
        try {
			gbd.conectar();
			Terminal terminal = new Terminal ("4", "Apple", "IPhone 5", 500, 400, 300, 200);
			gbd.insertarTerminal(terminal);
			
			terminal = gbd.obtenerTerminal("4");
			this.visualizarTerminal(terminal);
			
			terminal.setPrecio(1000);
			gbd.actualizarTerminal("4", terminal);
			terminal = gbd.obtenerTerminal("4");
			this.visualizarTerminal(terminal);
			
			gbd.borrarTerminal("4");
			
			Vector<Terminal> terminales;
			terminales = gbd.obtenerTerminales();
			this.visualizarTerminales(terminales);
			
			terminales = gbd.obtenerTerminalesPorMarca("Apple");
			this.visualizarTerminales(terminales);
			
			terminales = gbd.obtenerTerminalesPorModelo("HD");
			this.visualizarTerminales(terminales);
			
			terminales = gbd.obtenerTerminalesPorPrecio(300, 400);
			this.visualizarTerminales(terminales);
									
			int count = gbd.contarTerminales();
			System.out.println("Terminales = " + count);
            
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public void testBorrarTodo(){
		GestorBD gbd = new GestorBD();
        try {
			gbd.conectar();
	        gbd.borrarFacturas();
	        gbd.borrarLineas();
	        gbd.borrarTerminales();
	        gbd.borrarClientes();
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    private void visualizarClientes(Vector<Cliente> v){
    	Iterator<Cliente> i = v.iterator();
    	while(i.hasNext()){
    		Cliente cliente = i.next();
    		visualizarCliente(cliente);
    	}
    }
    
    private void visualizarCliente(Cliente c){
    	System.out.println(c.getDni()+ "\t" + c.getNombre()+ "\t" + c.getDireccion()+ "\t" + c.getEmail());
    }
    
    private void visualizarLineas(Vector<Linea> v){
    	Iterator<Linea> i = v.iterator();
    	while(i.hasNext()){
    		Linea linea = i.next();
    		visualizarLinea(linea);
    	}
    }
    
    private void visualizarLinea(Linea l){
    	System.out.println(l.getTelefono() + "\t" + l.getAntiguedad() + "\t" + l.isActiva() + "\t" + l.getTarifaVoz() + "\t" + l.getTarifaDatos() + "\t" + l.getPromocion() + "\t" + l.getDni());
    }
    
    private void visualizarFactura(Factura f){
    	System.out.println(f.getIdFactura() + "\t" + f.getFecha() + "\t" + f.getPeriodo() + "\t" + f.getImporte() + "\t" + f.getTelefono());
    }
    
    private void visualizarFacturas(Vector<Factura> v){
    	Iterator<Factura> i = v.iterator();
    	while(i.hasNext()){
    		Factura factura = i.next();
    		visualizarFactura(factura);
    	}
    }

    private void visualizarTerminal(Terminal t){
    	System.out.println(t.getIdTerminal() + "\t" + t.getMarca() + "\t" + t.getModelo() + "\t" + t.getPrecio() + "\t" + t.getPromoOro() + "\t" + t.getPromoPlata() + "\t" + t.getPromoBronce());
    }
    
    private void visualizarTerminales(Vector<Terminal> v){
    	Iterator<Terminal> i = v.iterator();
    	while(i.hasNext()){
    		Terminal terminal = i.next();
    		visualizarTerminal(terminal);
    	}
    }

    
    public static void main(String[] args) {
        Test test = new Test();
        test.testClientes();
        test.testLineas();
        //test.testFacturas();
        test.testBorrarTodo();
        System.out.println("Done!");
    }

}
