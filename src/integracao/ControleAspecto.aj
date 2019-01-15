package integracao;

import javax.swing.JOptionPane;

import visao.*;
import modelo.*;
import DAO.*;

public aspect ControleAspecto {
	Acesso vendas = new Acesso();
	
	pointcut abrir() : set (String PrincipalVisual.nomeArquivo);
	pointcut calcula(): set(String PrincipalVisual.calcAno);
//	pointcut itemvendido(): set(String PrincipalVisual.);
	
	after(PrincipalVisual pv) : abrir() && target(pv){
//		JOptionPane.showMessageDialog(null, "Voc� abriu o arquivo!");
		
		VendasDAO vdao = new VendasDAO();
		vdao.setArquivo(pv.getNomeArquivo());
		vendas.setVendas(vdao.consultaVendas());
	}
	
	after(PrincipalVisual pv) : calcula() && target(pv){
		System.out.println("M�s/Ano escolhido: " + pv.getCalcMes()+"/"+pv.getCalcAno());
		float v = vendas.calcular(pv.getCalcMes(), pv.getCalcAno());

		if (v == 0){
			JOptionPane.showMessageDialog(null, "N�o houve vendas nesse per�odo");
		}else{
			JOptionPane.showMessageDialog(null, "O total de vendas foi: " + v);
		}
	}

}
