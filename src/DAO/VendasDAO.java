package DAO;


import java.util.ArrayList;
import java.io.*;

import modelo.Vendas;

public class VendasDAO {
	String arquivo = "";
	
	public String getArquivo() {
		return arquivo;
	}
	
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	public ArrayList<Vendas> consultaVendas(){
		ArrayList<Vendas> vendas = new ArrayList<Vendas>();
		
		try {
			InputStream is = new FileInputStream (arquivo);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);		
			Vendas v;
			
			int barra, virgula;
			
			String s = br.readLine(); // primeira linha
			s = br.readLine();
			
			while (s != null) {
				//System.out.println(s);
				
				v = new Vendas();
				
				//Até a primeira informação
				virgula = s.indexOf(';');
				s = s.substring(virgula+1);
				virgula = s.indexOf(';');
				
				//pegar item
				v.setItem(s.substring(0,virgula));
				s = s.substring(virgula+1);
				virgula = s.indexOf(';');
				
				//Pegar quantidade
				v.setQuantidade(s.substring(0,virgula));
				s = s.substring(virgula+1);
				virgula = s.indexOf(';');
				
				//Pegar preço unitário
				v.setPrecoUnit(s.substring(0,virgula));
				s = s.substring(virgula+1);
				virgula = s.indexOf(';');
				
				//Mês
				s = s.substring(virgula+1);
				barra = s.indexOf('/');
				s = s.substring(barra+1);
				barra = s.indexOf('/');
				v.setMes(s.substring(0,barra));
				
				//Ano
				v.setAno(s.substring(barra+1));
				
				s = br.readLine();
				
				vendas.add(v);
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendas;
	}

}
