package rocha.guilherme.jose.model;

import java.util.Random;

public class ModelGerarSenha {

	private int quantLetras;
	private int quantNumeros;
	private int quantCaracteres;
	private String formaDaLetra;
	private String palavraPessoal;
	private String senhaGerada;
	
	public ModelGerarSenha() {
		
	}
	
	public ModelGerarSenha(int quantLetras, int quantNumeros, int quantCaracteres, String formaDaLetra,
			String palavraPessoal) {
		this.quantLetras = quantLetras;
		this.quantNumeros = quantNumeros;
		this.quantCaracteres = quantCaracteres;
		this.formaDaLetra = formaDaLetra;
		this.palavraPessoal = palavraPessoal;
	}

	public int getQuantLetras() {
		return quantLetras;
	}

	public void setQuantLetras(int quantLetras) {
		this.quantLetras = quantLetras;
	}

	public int getQuantNumeros() {
		return quantNumeros;
	}

	public void setQuantNumeros(int quantNumeros) {
		this.quantNumeros = quantNumeros;
	}

	public int getQuantCaracteres() {
		return quantCaracteres;
	}

	public void setQuantCaracteres(int quantCaracteres) {
		this.quantCaracteres = quantCaracteres;
	}

	public String getFormaDaLetra() {
		return formaDaLetra;
	}

	public void setFormaDaLetra(String formaDaLetra) {
		this.formaDaLetra = formaDaLetra;
	}

	public String getPalavraPessoal() {
		return palavraPessoal;
	}

	public void setPalavraPessoal(String palavraPessoal) {
		this.palavraPessoal = palavraPessoal;
	}

	public String getSenhaGerada() {
		return senhaGerada;
	}

	public void setSenhaGerada(String senhaGerada) {
		this.senhaGerada = senhaGerada;
	}
	
	public void gerarSenha() {
		StringBuilder senha = construirSenha();
    	Random random = new Random();
        
        String formaEscolhida = formaDaLetra();
        String numeros = "1234567890";
        String caracteresEspeciais = "!@#$%&-_=?";
        
		StringBuilder letrasGeradas = gerarSenhaAleatoria(formaEscolhida, random, senha, quantLetras);
		StringBuilder numerosGerados = gerarSenhaAleatoria(numeros, random, letrasGeradas, quantNumeros);
		StringBuilder caracteresEspeciaisGerados = gerarSenhaAleatoria(caracteresEspeciais, random, numerosGerados, quantCaracteres);
		
		String senhaGerada = embaralharSenha(random, caracteresEspeciaisGerados);
		this.senhaGerada = senhaGerada;
	}

	private StringBuilder construirSenha() {
		int tamanho = quantLetras + quantNumeros + quantCaracteres;
        StringBuilder senha = new StringBuilder(tamanho);
        return senha;
	}

	private String formaDaLetra() {
		
		if(formaDaLetra.equals("Só Maiúsculas")) {
    		return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	}
    	
    	if(formaDaLetra.equals("Só Minúsculas")) {
    		return "abcdefghijklmnopqrstuvwxyz";    		
    	}
    	
    	if(formaDaLetra.equals("Maiúsculas e Minúsculas")) {
    		return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    	}
    	
    	return null;
	}

	private StringBuilder gerarSenhaAleatoria(String conjunto, Random random, StringBuilder senha, int quantidade) {
    	
    	for(int letra = 0; letra < quantidade; letra++) {
    		int index = random.nextInt(conjunto.length());
    		senha.append(conjunto.charAt(index));
    	}
    	
		return senha;
	}
	
	private String embaralharSenha(Random random, StringBuilder senha) {
		String embaralhar = senha.toString();
        StringBuilder senhaEmbaralhada = new StringBuilder(embaralhar.length());
        
        while (embaralhar.length() > 0) {
            int index = random.nextInt(embaralhar.length());
            senhaEmbaralhada.append(embaralhar.charAt(index));
            embaralhar = embaralhar.substring(0, index) + embaralhar.substring(index + 1);
        }
        
		if(palavraPessoal != null) {
			int posicaoAleatoria = random.nextInt(senha.length() + 1);
			senhaEmbaralhada.insert(posicaoAleatoria, palavraPessoal);
		}
		
		return senhaEmbaralhada.toString();
	}
	
}
