package rocha.guilherme.jose.controller.helper;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;

import rocha.guilherme.jose.model.ModelGerarSenha;
import rocha.guilherme.jose.view.GerarSenhaPanel;

public class GerarSenhaHelper {

	private GerarSenhaPanel gerarSenhaPanel;

	public GerarSenhaHelper(GerarSenhaPanel gerarSenhaPanel) {
		this.gerarSenhaPanel = gerarSenhaPanel;
	}
	
	public ModelGerarSenha obterModelo() {
		String quantLetras = gerarSenhaPanel.getTextFieldQuantLetras().getText();
		String quantNumeros = gerarSenhaPanel.getTextFieldQuantNumeros().getText();
		String quantCaracteres = gerarSenhaPanel.getTextFieldQuantCaracteresEspeciais().getText();
		String formaLetra = obterFormaLetra();
		String palavraPessoal = obterPalavraPessoal();
		
		int quantLetrasConvertida = converterQuantidade(quantLetras);
		int quantNumeroConvertida = converterQuantidade(quantNumeros);
		int quantCaractereConvertida = converterQuantidade(quantCaracteres);

		ModelGerarSenha senhaTela = new ModelGerarSenha(quantLetrasConvertida, quantNumeroConvertida, quantCaractereConvertida, formaLetra, palavraPessoal);
		
		return senhaTela;
	}

	private String obterFormaLetra() {
	    ButtonModel formaSelecionada = gerarSenhaPanel.getFormaDaLetra().getSelection();
	    
        for (Enumeration<AbstractButton> opcoes = gerarSenhaPanel.getFormaDaLetra().getElements(); opcoes.hasMoreElements();) {
            AbstractButton botao = opcoes.nextElement();
            if (botao.getModel() == formaSelecionada) {
                return botao.getText();
            }
        }
        
		return null;
	}
	
	private String obterPalavraPessoal() {
		ButtonModel palavraPessoal = gerarSenhaPanel.getPalavraPessoal().getSelection();
	    
        for (Enumeration<AbstractButton> opcoes = gerarSenhaPanel.getPalavraPessoal().getElements(); opcoes.hasMoreElements();) {
            AbstractButton botao = opcoes.nextElement();
            if(botao.getModel() == palavraPessoal) {
            	if (botao.getText().equals("Sim")) {
            		return gerarSenhaPanel.getTextFieldPalavraPessoal().getText();
            	}
            }
        }
        
		return null;
	}
	
	private int converterQuantidade(String quantidadeTela) {
		int quantidade = 0;
		
		if(quantidadeTela.trim().isEmpty()) {
			return quantidade;
		}
		
		try {
			quantidade = Integer.parseInt(quantidadeTela);
		} catch (NumberFormatException e) {
			return -1;
		}
		
		return quantidade;
	}

	public boolean validarQuantLetras() {
		if(converterQuantidade(gerarSenhaPanel.getTextFieldQuantLetras().getText()) == -1) {
			return false;
		}
		
		return true;
	}

	public boolean validarQuantNumeros() {
		if(converterQuantidade(gerarSenhaPanel.getTextFieldQuantNumeros().getText()) == -1) {
			return false;
		}
		
		return true;
	}

	public boolean validarQuantCaractere() {
		if(converterQuantidade(gerarSenhaPanel.getTextFieldQuantCaracteresEspeciais().getText()) == -1) {
			return false;
		}
		
		return true;
	}

	public boolean validarPalavraPessoal() {
		if(obterPalavraPessoal() == null){
			return true;
		}
		
		String palavraPessoal = gerarSenhaPanel.getTextFieldPalavraPessoal().getText();
		
		if(!palavraPessoal.matches("[\\p{L} ]+")) {
			return false;			
		}
		
		return true;
	}

	public boolean validarTamanhoDaSenha(ModelGerarSenha senhaTela) {
		int tamanhoSenha = senhaTela.getQuantLetras() + senhaTela.getQuantNumeros() + senhaTela.getQuantCaracteres();
		
		if(tamanhoSenha < 8 || tamanhoSenha > 30) {
			return false;
		}

		return true;
	}

	public void mostrarSenha(ModelGerarSenha senha) {
		gerarSenhaPanel.getTextFieldSenhaGerada().setText(senha.getSenhaGerada());
		
	}

}
