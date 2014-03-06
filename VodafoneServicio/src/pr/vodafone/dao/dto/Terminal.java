package pr.vodafone.dao.dto;

public class Terminal {
	private String idTerminal;
	private String marca;
	private String modelo;
	private float precio;
	private float promoOro;
	private float promoPlata;
	private float promoBronce;
	
	public Terminal(){
		super();
	}
	public Terminal(String idTerminal, String marca, String modelo, float precio,
			float promoOro, float promoPlata, float promoBronce) {
		super();
		this.idTerminal = idTerminal;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.promoOro = promoOro;
		this.promoPlata = promoPlata;
		this.promoBronce = promoBronce;
	}
	public String getIdTerminal() {
		return idTerminal;
	}
	public void setIdTerminal(String idTerminal) {
		this.idTerminal = idTerminal;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getPromoOro() {
		return promoOro;
	}
	public void setPromoOro(float promoOro) {
		this.promoOro = promoOro;
	}
	public float getPromoPlata() {
		return promoPlata;
	}
	public void setPromoPlata(float promoPlata) {
		this.promoPlata = promoPlata;
	}
	public float getPromoBronce() {
		return promoBronce;
	}
	public void setPromoBronce(float promoBronce) {
		this.promoBronce = promoBronce;
	}
}
