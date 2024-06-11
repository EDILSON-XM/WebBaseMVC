package modelo;

import java.sql.Date;
import java.util.Objects;

public class Empleado {

	private String nDIEmp;
	private String nomEmp;
	private String sexEmp;
	private Date fecNac;
	private Date fecIncorporacion;
	private Float salEmp;
	private Float comisionE;
	private  String cargoE;
	private String jefeID;
	private String codDepto;
	
	
	public Empleado() {
		this.nDIEmp="";
		this.nomEmp="";
		this.sexEmp="";
		this.fecIncorporacion=new Date(0);
		this.salEmp=0f;
		this.comisionE=0f;
		this.cargoE="";
		this.jefeID="";
		this.codDepto="";
		
		
	
	}


	public Empleado(String nDIEmp, String nomEmp, String sexEmp, Date fecNac, Date fecIncorporacion, Float salEmp,
			Float comisionE, String cargoE, String jefeID, String codDepto) {
		
		this.nDIEmp = nDIEmp;
		this.nomEmp = nomEmp;
		this.sexEmp = sexEmp;
		this.fecNac = fecNac;
		this.fecIncorporacion = fecIncorporacion;
		this.salEmp = salEmp;
		this.comisionE = comisionE;
		this.cargoE = cargoE;
		this.jefeID = jefeID;
		this.codDepto = codDepto;
	}


	public String getnDIEmp() {
		return nDIEmp;
	}


	public void setnDIEmp(String nDIEmp) {
		this.nDIEmp = nDIEmp;
	}


	public String getNomEmp() {
		return nomEmp;
	}


	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}


	public String getSexEmp() {
		return sexEmp;
	}


	public void setSexEmp(String sexEmp) {
		this.sexEmp = sexEmp;
	}


	public Date getFecNac() {
		return fecNac;
	}


	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}


	public Date getFecIncorporacion() {
		return fecIncorporacion;
	}


	public void setFecIncorporacion(Date fecIncorporacion) {
		this.fecIncorporacion = fecIncorporacion;
	}


	public Float getSalEmp() {
		return salEmp;
	}


	public void setSalEmp(Float salEmp) {
		this.salEmp = salEmp;
	}


	public Float getComisionE() {
		return comisionE;
	}


	public void setComisionE(Float comisionE) {
		this.comisionE = comisionE;
	}


	public String getCargoE() {
		return cargoE;
	}


	public void setCargoE(String cargoE) {
		this.cargoE = cargoE;
	}


	public String getJefeID() {
		return jefeID;
	}


	public void setJefeID(String jefeID) {
		this.jefeID = jefeID;
	}


	public String getCodDepto() {
		return codDepto;
	}


	public void setCodDepto(String codDepto) {
		this.codDepto = codDepto;
	}


	@Override
	public String toString() {
		return "Empleado [nDIEmp=" + nDIEmp + ", nomEmp=" + nomEmp + ", sexEmp=" + sexEmp + ", fecNac=" + fecNac
				+ ", fecIncorporacion=" + fecIncorporacion + ", salEmp=" + salEmp + ", comisionE=" + comisionE
				+ ", cargoE=" + cargoE + ", jefeID=" + jefeID + ", codDepto=" + codDepto + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(nDIEmp);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(nDIEmp, other.nDIEmp);
	}


	
	

	
	
	
}
