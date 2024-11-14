package rocha.guilherme.jose.controller;

import javax.persistence.EntityManager;

import rocha.guilherme.jose.controller.helper.RedefinirSenhaHelper;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.UsuarioDAO;
import rocha.guilherme.jose.servico.Criptografar;
import rocha.guilherme.jose.servico.Email;
import rocha.guilherme.jose.servico.JPAConnection;
import rocha.guilherme.jose.view.RedefinirSenhaView;

public class RedefinirSenhaController {

	private final RedefinirSenhaView redefinirSenhaView;
	private final RedefinirSenhaHelper helper;
	private final EntityManager em;
	private String codigoGerado;
	
	public RedefinirSenhaController(RedefinirSenhaView redefinirSenhaView) {
		this.redefinirSenhaView = redefinirSenhaView;
		this.helper = new RedefinirSenhaHelper(redefinirSenhaView);
		this.em = new JPAConnection().getEntityManager();
	}
	
	public void enviarCodigo() {
		String email = helper.obterEmail();
		
		if(!email.isEmpty()) {
			if(helper.validarEmail()) {
				if(buscarUsuario() != null) {
					codigoGerado = Email.gerarOTP();
					Email.enviarEmail(email, codigoGerado);
				}else {
					redefinirSenhaView.exibeMensagemInformativa("Esse email n�o est� associado a nenhuma conta cadastrada!");
				}
			}else {
				redefinirSenhaView.exibeMensagemInformativa("Digite um email v�lido!");
			}
		}else {
			redefinirSenhaView.exibeMensagemInformativa("Informe o email!");
		}
	}

	private Boolean validarCodigo() {
		String codigoInserido = helper.obterCodigo();
		return codigoInserido.equals(codigoGerado);
	}

	private ModelUsuario buscarUsuario() {
		String email = helper.obterEmail();
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		
		for(ModelUsuario usuario: usuarioDAO.selectAll()) {
			if(email.equals(usuario.getEmailUsuario())) {
				return usuario;
			}
		}
		
		return null;
	}

	public void redefinirSenha() {
		em.getTransaction().begin();
		
		ModelUsuario usuario = buscarUsuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		
		if(helper.verificarCampos()) {
			if(helper.validarEmail()) {
				if(usuario != null) {
					if(helper.validarSenha()) {
						if(validarCodigo()) {
							usuario.setSenhaUsuario(helper.obterSenha());
							criptografarSenha(usuario);
							usuarioDAO.update(usuario);
							redefinirSenhaView.exibeMensagemInformativa("Senha alterada com sucesso!");
							redefinirSenhaView.dispose();
						}else {
							redefinirSenhaView.exibeMensagemInformativa("O c�digo digitado est� incorreto!");
						}
					}else {
						redefinirSenhaView.exibeMensagemInformativa("Sua senha n�o pode ter menos que 8 caracteres!");
					}
				}else {
					redefinirSenhaView.exibeMensagemInformativa("Esse gmail n�o pertence a nenhuma conta registrada!");
				}
			}else {
				redefinirSenhaView.exibeMensagemInformativa("Digite um gmail v�lido!");
			}
		}else {
			redefinirSenhaView.exibeMensagemInformativa("Preencha todos os campos!");
		}
		
		em.getTransaction().commit();
		
	}

	private void criptografarSenha(ModelUsuario usuario) {
		usuario.setSenhaUsuario(Criptografar.criptografar(usuario.getSenhaUsuario()));
	}
	
	public void sair() {
		redefinirSenhaView.dispose();
	}
	
}
