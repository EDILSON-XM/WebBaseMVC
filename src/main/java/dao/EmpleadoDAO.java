package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Empleado;

public class EmpleadoDAO {
	
	private ConexionBD conexion;

	// Inicializa el objeto de conexion a la base de datos
	public EmpleadoDAO() {
		this.conexion =  new ConexionBD();
	}
	
	public ArrayList<Empleado> getListaEmpleados() {
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		
		Connection con = conexion.getConexion();
		Statement sentencia = null;
		ResultSet resultado=null;
		
		try {
			sentencia = con.createStatement();
			resultado= sentencia.executeQuery(
					"SELECT * FROM empleados");
			while (resultado.next()) {
				String nDIEmp = resultado.getString("nDIEmp");
				String  nomEmp= resultado.getString("nomEmp");
				String sexEmp = resultado.getString("sexEmp");
				Date fecNac=resultado.getDate("fecNac");
				Date fecIncorporacion= resultado.getDate("fecIncorporacion");
				Float salEmp=resultado.getFloat("salEmp");
				Float comisionE= resultado.getFloat("comisionE");
				String cargoE = resultado.getString("cargoE");
				String jefeID = resultado.getString("jefeID");
				String  codDepto = resultado.getString("codDepto");
				
				
			Empleado emp = new Empleado(nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto);
				
				lista.add(emp);
			}	
		} catch (SQLException e) {
			System.out.println("error "+ e.getMessage());
		} finally {
			try {
				resultado.close();
				sentencia.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar los datos");
			}
			
		}
		return lista;
	}
	
	public Empleado getEmpleado(String nDIEmp) {
		
		Connection con = conexion.getConexion();
		PreparedStatement sentencia = null;
		ResultSet resultado=null;
		Empleado Empleados=null;
		
		try {
			sentencia = con.prepareStatement("SELECT * FROM Empleados where nDIEmp=?");
			sentencia.setString(1, nDIEmp);
			resultado= sentencia.executeQuery();
			if (resultado.next()) {
		
				String  nomEmp= resultado.getString("nomEmp");
				String sexEmp = resultado.getString("sexEmp");
				Date fecNac=resultado.getDate("fecNac");
				Date fecIncorporacion= resultado.getDate("fecIncorporacion");
				Float salEmp=resultado.getFloat("salEmp");
				Float comisionE= resultado.getFloat("comisionE");
				String cargoE = resultado.getString("cargoE");
				String jefeID = resultado.getString("jefeID");
				String  codDepto = resultado.getString("codDepto");
				
				
			
				
				
				Empleados = new Empleado(nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto);
			}	
		} catch (SQLException e) {
			System.out.println("error al recuperar departamento "+ e.getMessage());
		} finally {
			try {
				resultado.close();
				sentencia.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar los datos");
			}
			
		}
		return Empleados;
	}
	
	public int insertarEmpleados(Empleado Empleados) {
		
		Connection con = conexion.getConexion();
		PreparedStatement sentencia = null;
		ResultSet resultado=null;
		
		try {
			sentencia = con.prepareStatement(
					"insert into Empleados nDIEmp,nomEmp,sexEmp,fecNac, fecIncorporacion,salEmp,comisionE,cargoE,jefeID,codDepto)"
					+" values (?,?,?,?)");
			sentencia.setString(1, Empleados.getnDIEmp());
			sentencia.setString(2, Empleados.getNomEmp());
			sentencia.setString(3, Empleados.getSexEmp());
			sentencia.setDate(4, Empleados.getFecNac());
			sentencia.setDate(5, Empleados.getFecIncorporacion());
			sentencia.setFloat(6, Empleados.getSalEmp());
			sentencia.setFloat(7, Empleados.getComisionE());
			sentencia.setString(8, Empleados.getCargoE());
			sentencia.setString(9, Empleados.getJefeID());
			sentencia.setString(10, Empleados.getCodDepto());
			
			resultado= sentencia.executeQuery();
			return 1;
		} catch (SQLException e) {
			System.out.println("error al insertar datos "+ e.getMessage());
		} finally {
			try {
				resultado.close();
				sentencia.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar los datos");
			}
			
		}
		return 0;
	}
	
	
	public int modificarEmpleado(Empleado emp) {
		
		Connection con = conexion.getConexion();
		PreparedStatement sentencia = null;
		ResultSet resultado=null;
		
		try {
			sentencia = con.prepareStatement(
					"update empleados "
					+ "set NomEmp=?, SexEmp=?,FecNac=?,FecIncorporacion=?,"
					+ "SalEmp=?,ComisionE=?,CargoE=?,JefeID=?,JCodDepto=?, )"
					+" where nDIEmp=? =?");
			
			

			sentencia.setString(1,emp.getNomEmp());
			sentencia.setString(2,emp.getSexEmp());
			sentencia.setDate(3,emp.getFecNac());
			sentencia.setDate(4,emp.getFecIncorporacion());
			sentencia.setFloat(5,emp.getSalEmp());
			sentencia.setFloat(6,emp.getComisionE());
			sentencia.setString(7,emp.getCargoE());
			sentencia.setString(8,emp.getJefeID());
			sentencia.setString(9,emp.getCodDepto());
			
			
			
			resultado= sentencia.executeQuery();
			return 1;
		} catch (SQLException e) {
			System.out.println("error al actualizar los  datos "+ e.getMessage());
		} finally {
			try {
				resultado.close();
				sentencia.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar los datos");
			}
			
		}
		return 0;
	}
	
public int eliminarEmpleados(String nDIEmp) {
		
		Connection con = conexion.getConexion();
		PreparedStatement sentencia = null;
		ResultSet resultado=null;
		
		try {
			sentencia = con.prepareStatement(
					"delete from Empleados "
					+ " where nDIEmp=?");
			sentencia.setString(1, nDIEmp);
			resultado= sentencia.executeQuery();
			return 1;
		} catch (SQLException e) {
			System.out.println("error al eliminar los  datos "+ e.getMessage());
		} finally {
			try {
				resultado.close();
				sentencia.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar los datos");
			}
			
		}
		return 0;
	}
}
