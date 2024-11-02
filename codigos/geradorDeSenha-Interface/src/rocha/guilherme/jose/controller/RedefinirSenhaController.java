package rocha.guilherme.jose.controller;

import rocha.guilherme.jose.controller.helper.RedefinirSenhaHelper;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.BancoDeDados;
import rocha.guilherme.jose.model.dao.UsuarioDAO;
import rocha.guilherme.jose.servico.Email;
import rocha.guilherme.jose.view.RedefinirSenhaView;

public class RedefinirSenhaController {

	private final RedefinirSenhaView redefinirSenhaView;
	private final RedefinirSenhaHelper helper;
	private String codigoGerado;
	
	public RedefinirSenhaController(RedefinirSenhaView redefinirSenhaView) {
		this.redefinirSenhaView = redefinirSenhaView;
		this.helper = new RedefinirSenhaHelper(redefinirSenhaView);
	}
	
	public void enviarCodigo() {
		if(helper.verificarEmail()) {
			if(buscarUsuario() != null) {
				String email = helper.obterEmail();
				codigoGerado = Email.gerarOTP();

				Email.enviarEmail(email, codigoGerado);
			}
		}
	}

	private Boolean validarCodigo() {
		String codigoInserido = helper.obterCodigo();
		return codigoInserido.equals(codigoGerado);
	}

	public void redefinirSenha() {
		ModelUsuario usuario = buscarUsuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		if(helper.verificarEmail()) {
			if(usuario != null) {
				if(helper.verificarCodigo()) {
					if(helper.validarSenha()) {
						if(validarCodigo()) {
							usuario.setSenhaUsuario(helper.obterSenha());
							usuarioDAO.update(usuario);
							redefinirSenhaView.exibeMensagemInformativa("Senha alterada com sucesso!");
							redefinirSenhaView.dispose();
						}else {
							redefinirSenhaView.exibeMensagemInformativa("O código digitado está incorreto!");
						}
					}else {
						redefinirSenhaView.exibeMensagemInformativa("Sua senha não pode ter menos que 8 caracteres!");
					}
				}else {
					redefinirSenhaView.exibeMensagemInformativa("Digite o código recebido!");
				}
			}else {
				redefinirSenhaView.exibeMensagemInformativa("Esse email não pertence a nenhuma conta registrada!");
			}
		}else {
			redefinirSenhaView.exibeMensagemInformativa("Digite o email para redefinir a senha!");
		}
		
	}

	private ModelUsuario buscarUsuario() {
		String email = helper.obterEmail();
		
		for(ModelUsuario usuario: BancoDeDados.usuarios) {
			if(email.equals(usuario.getEmailUsuario())) {
				return usuario;
			}
		}
		
		return null;
	}
	
	public void sair() {
		redefinirSenhaView.dispose();
	}
	
}
