package modelo;

import java.util.ArrayList;

public class Acesso {
		ArrayList<Vendas> vendas = null;

		public ArrayList<Vendas> getVendas() {
			return vendas;
		}

		public void setVendas(ArrayList<Vendas> vendas) {
			this.vendas = vendas;
		}

		public float calcular (String mes, String ano){
			boolean achei = false;
			int i = 0;
			float total = 0;
			
//			System.out.println(mes+"/"+ano);
//			System.out.println(vendas.size());
			
			for(i=0;i<vendas.size();i++){
				achei = false;
				System.out.println(vendas.get(i).getMes() + "/" + vendas.get(i).getAno());
				if (vendas.get(i).getMes().equals(mes) && vendas.get(i).getAno().equals(ano)) achei = true;
				if (achei){
					total += Float.parseFloat(vendas.get(i).getQuantidade())*Float.parseFloat(vendas.get(i).getPrecoUnit());
					System.out.println(total);
				}
			}
			return total;
		}
		
		public String[] maisVendido(){
			String[][] itensVendidos = new String[50][2];
			
			int i = 0, j = 0, encontrou = 0; //não encontrou = 0; encontrou = 1
			
			//lista com os diferentes item reunidos
			itensVendidos[i][0] = vendas.get(i).getItem();
			for(i=1;i<50;i++){
				for(j=0;j<i;j++){
					if(itensVendidos[i][0].equals(itensVendidos[j][0])){
						encontrou = 1;
					}
				}
				if(encontrou == 0){
					itensVendidos[i][0] = vendas.get(i).getItem();
				} else{
					itensVendidos[j][0] += vendas.get(i).getItem();
				}
			}
			
			//ver qual é maior
			i=0;
			int maior = Integer.parseInt(itensVendidos[i][1]);
			for(i=1;i<50;i++){
				if()
			}
			
			return itensVendidos[j];
		}

}
