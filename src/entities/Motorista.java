package entities;

import java.text.DecimalFormat;

import entities.enums.Natureza;

public class Motorista {

	DecimalFormat dec = new DecimalFormat("0.00");
	
	private Integer numeroCnh;
	private Float   valorMulta;
	private Integer pontos;
	private Float   totalMultas = 0f;
	private Integer leve        = 0;
	private Integer media       = 0;
	private Integer grave       = 0;
	private Integer gravissima  = 0;
	private Integer somaPontos  = 0;
	
	private Natureza natureza;
	
	public Motorista() {		
	}
	
	//construtor para adicionar os dados a tabela
	public Motorista(Integer numeroCnh, Float valorMulta, Integer pontos, Float totalMultas, Integer somaPontos, Natureza natureza) {	
		this.numeroCnh   = numeroCnh;
		this.valorMulta  = valorMulta;
		this.pontos      = pontos;
		this.totalMultas = totalMultas;
		this.somaPontos  = somaPontos;
		this.natureza    = natureza;
	}
	
	public Motorista(Integer numeroCnh, Float valorMulta, Integer pontos, Float totalMultas, Integer leve, Integer media, Integer grave,
			Integer gravissima, Integer somaPontos, Natureza natureza) {
		this.numeroCnh   = numeroCnh;
		this.valorMulta  = valorMulta;
		this.pontos      = pontos;
		this.totalMultas = totalMultas;		
		this.leve        = leve;
		this.media       = media;
		this.grave       = grave;
		this.gravissima  = gravissima;
		this.somaPontos  = somaPontos;
		this.natureza    = natureza;		
	}

	public Integer getNumeroCnh() {
		return numeroCnh;
	}

	public void setNumeroCnh(Integer numeroCnh) {
		this.numeroCnh = numeroCnh;
	}

	public Float getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(Float valorMulta) {
		this.valorMulta = valorMulta;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Float getTotalMultas() {
		return totalMultas;
	}

	public void setTotalMultas(Float totalMultas) {
		this.totalMultas = totalMultas;
	}

	public Integer getLeve() {
		return leve;
	}

	public void setLeve(Integer leve) {
		this.leve = leve;
	}

	public Integer getMedia() {
		return media;
	}

	public void setMedia(Integer media) {
		this.media = media;
	}

	public Integer getGrave() {
		return grave;
	}

	public void setGrave(Integer grave) {
		this.grave = grave;
	}

	public Integer getGravissima() {
		return gravissima;
	}

	public void setGravissima(Integer gravissima) {
		this.gravissima = gravissima;
	}
		
	public Integer getSomaPontos() {
		return somaPontos;
	}

	public void setSomaPontos(Integer somaPontos) {
		this.somaPontos = somaPontos;
	}

	public Natureza getNatureza() {
		return natureza;
	}

	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}

	//Calcula os pontos, o valor da multa e traz a natureza da multa
	public int pontuacao(char natureza){
		//Faz o teste a partir de uma variavel char
		switch (natureza) {
		    case ('L'):
		    	pontos     = leve + 3;
		    	valorMulta = 88f;
		    	setNatureza(Natureza.LEVE);
	    	    break;
		    case ('M'):
		    	pontos     = media + 4;
		    	valorMulta = 130f;
		    	setNatureza(Natureza.M?DIA);
		    	break;
		    case ('G'):
		    	pontos     = grave + 5;
		    	valorMulta = 195f;
		    	setNatureza(Natureza.GRAVE);
	    	    break;
		    case ('V'):
		    	pontos     = gravissima + 7;
		    	valorMulta = 293f;
		    	setNatureza(Natureza.GRAV?SSIMA);
	    	    break;  
	    	default:
	    		throw new IllegalArgumentException("Valor inv?lido");
		}
		somaPontos  += pontos;
		totalMultas += valorMulta;
		return pontos;
	}
	
	//Faz a impressao dos dados, os mesmos do construtor
	public String toString() {
		return "Numero da CNH: "      + getNumeroCnh()
			  +	"\nNatureza: "        + getNatureza().toString()
		      + "\nPontos: "          + getPontos()
		      + "\nValor: R$"         + dec.format(getValorMulta())
		      + "\nTotal de pontos: " + getSomaPontos()
		      + "\nValor total: R$"   + dec.format(getTotalMultas());
	}
}
