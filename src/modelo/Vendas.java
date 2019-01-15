package modelo;

public class Vendas {
	String item;
	String quantidade;
	String precoUnit;
	String mes;
	String ano;
	
	//ITEM
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	//QUANTIDADE
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	//PREÇO UNITARIO
	public String getPrecoUnit() {
		return precoUnit;
	}
	public void setPrecoUnit(String precoUnit) {
		this.precoUnit = precoUnit;
	}
	
	//MES
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	//ANO
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
}
