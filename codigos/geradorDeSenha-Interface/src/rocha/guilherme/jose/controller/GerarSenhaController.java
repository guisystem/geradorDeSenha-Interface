package rocha.guilherme.jose.controller;

import javax.persistence.EntityManager;

import rocha.guilherme.jose.controller.helper.GerarSenhaHelper;
import rocha.guilherme.jose.model.ModelGerarSenha;
import rocha.guilherme.jose.model.ModelSenhasSalvas;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.SenhasSalvasDAO;
import rocha.guilherme.jose.servico.JPAConnection;
import rocha.guilherme.jose.view.GerarSenhaPanel;
import rocha.guilherme.jose.view.SalvarSenhaView;

public class GerarSenhaController {

	private GerarSenhaPanel gerarSenhaPanel;
	private GerarSenhaHelper helper;
	private EntityManager em;
	
	public GerarSenhaController(GerarSenhaPanel gerarSenhaPanel) {
		this.gerarSenhaPanel = gerarSenhaPanel;
		this.helper = new GerarSenhaHelper(gerarSenhaPanel);
		this.em = new JPAConnection().getEntityManager();
	}

	public void gerarSenha() {
		ModelGerarSenha senha = helper.obterModelo();
		SenhasSalvasDAO senhasSalvas = new SenhasSalvasDAO(em);
		
		if(helper.validarQuantLetras()) {
			if(helper.validarQuantNumeros()) {
				if(helper.validarQuantCaractere()) {
					if(helper.validarPalavraPessoal()) {
						if(helper.validarTamanhoDaSenha(senha)) {
							senha.gerarSenha();
							
							while(senhasSalvas.senhaExiste(senha) != null) {
								senha.gerarSenha();
							}
							
							helper.mostrarSenha(senha);
						}else {
							gerarSenhaPanel.exibeMensagemInformativa("O tamanho da sua senha(Sem contar a "
									+ "palavra pessoal)\nnão pode ser menor que 8 ou maior que 30.");
						}
					}else {
						gerarSenhaPanel.exibeMensagemInformativa("A sua palavra não pode está vazia e\n "
								+ "deve conter apenas letras!");
					}
				}else {
					gerarSenhaPanel.exibeMensagemInformativa("A quantidade de caracteres deve conter\n "
							+ "apenas números e ser um inteiro(1, 2, 3, 4...)!");
				}
			}else {
				gerarSenhaPanel.exibeMensagemInformativa("A quantidade de números deve conter apenas\n "
						+ "números e ser um inteiro(1, 2, 3, 4...)!");
			}
		}else {
			gerarSenhaPanel.exibeMensagemInformativa("A quantidade de letras deve conter apenas números\n "
					+ "e ser um inteiro(1, 2, 3, 4...)!");
		}
	}

	public void abrirFecharCampoPalavra() {
		if(gerarSenhaPanel.getRdbtnPalavraSim().isSelected()) {
			gerarSenhaPanel.getTextFieldPalavraPessoal().setEditable(true);
		}else {
			gerarSenhaPanel.getTextFieldPalavraPessoal().setEditable(false);
		}
	}

	public void irParaTelaDeSalvarSenha(ModelUsuario usuario) {
		if(helper.validarSenhaGerada()) {
			SalvarSenhaView salvarSenhaView = new SalvarSenhaView(usuario, getSenha());
			salvarSenhaView.setResizable(false);
			salvarSenhaView.setLocationRelativeTo(null);
			salvarSenhaView.setVisible(true);
		}else {
			gerarSenhaPanel.exibeMensagemInformativa("Para salvar a senha é preciso que ela tenha\n "
					+ "um tamanho entre 8 e 30.");
		}
	}

	private ModelSenhasSalvas getSenha() {
		ModelSenhasSalvas senhaNova = new ModelSenhasSalvas(helper.getSenhaGerada(), "");
		return senhaNova;
	}
	
	
}
