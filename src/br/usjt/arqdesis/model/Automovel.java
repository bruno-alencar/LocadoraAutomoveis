package br.usjt.arqdesis.model;

public class Automovel {
	private String chassi;
	private String placa;
	private String cidade;
	private int km;
	private String estado;
	private String modelo;
	private String fabricante;
	private double tarifa_km_livre;
	private double tarifa_km_controlado;
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public double getTarifa_km_livre() {
		return tarifa_km_livre;
	}
	public void setTarifa_km_livre(double tarifa_km_livre) {
		this.tarifa_km_livre = tarifa_km_livre;
	}
	public double getTarifa_km_controlado() {
		return tarifa_km_controlado;
	}
	public void setTarifa_km_controlado(double tarifa_km_controlado) {
		this.tarifa_km_controlado = tarifa_km_controlado;
	}
	@Override
	public String toString() {
		return "Automovel [chassi=" + chassi + ", placa=" + placa + ", cidade=" + cidade + ", km=" + km + ", estado="
				+ estado + ", modelo=" + modelo + ", fabricante=" + fabricante + ", tarifa_km_livre=" + tarifa_km_livre
				+ ", tarifa_km_controlado=" + tarifa_km_controlado + "]";
	}
	
	
	
}
