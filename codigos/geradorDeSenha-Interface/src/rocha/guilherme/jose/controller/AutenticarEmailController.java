package rocha.guilherme.jose.controller;

import javax.persistence.EntityManager;
import javax.swing.SwingUtilities;

import rocha.guilherme.jose.controller.helper.AutenticarEmailHelper;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.UsuarioDAO;
import rocha.guilherme.jose.servico.Criptografar;
import rocha.guilherme.jose.servico.Email;
import rocha.guilherme.jose.servico.JPAConnection;
import rocha.guilherme.jose.view.AutenticarEmailView;
import rocha.guilherme.jose.view.CadastroUsuarioView;
import rocha.guilherme.jose.view.IconeCirculoRotativo;
import rocha.guilherme.jose.view.SenhasView;

public class AutenticarEmailController {

	private final AutenticarEmailView autenticarEmailView;
	private final AutenticarEmailHelper helper;
	private final EntityManager em;
	private String codigoGerado;
	
	public AutenticarEmailController(AutenticarEmailView autenticarEmailView) {
		this.autenticarEmailView = autenticarEmailView;
		this.helper = new AutenticarEmailHelper(autenticarEmailView);
		this.em = new JPAConnection().getEntityManager();
	}

	public void enviarCodigo(IconeCirculoRotativo circulo) {
		String email = helper.obterEmail();
        codigoGerado = Email.gerarOTP();

        Thread threadEnvio = new Thread(() -> {
            try {
                Email.enviarEmail(email, codigoGerado);
                circulo.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
               SwingUtilities.invokeLater(() -> {
            	   circulo.setVisible(false);
            	   autenticarEmailView.exibeMensagemInformativa("Erro ao enviar e-mail!");
                });
            }
        });

        threadEnvio.start();
	}

	public Boolean validarCodigo() {
		String codigoInserido = helper.obterCodigo();
        return codigoInserido.equals(codigoGerado);
	}

	public void cadastrarUsuario(ModelUsuario usuario, CadastroUsuarioView cadastroView) {
		em.getTransaction().begin();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		
		if(helper.verificarCodigo()) {
			if(validarCodigo()) {
				criptografarSenha(usuario);
				usuarioDAO.insert(usuario);
				irParaTelaInicial(usuario);
				cadastroView.dispose();
				autenticarEmailView.dispose();
			}else {
				autenticarEmailView.exibeMensagemInformativa("O c�digo digitado est� incorreto!");
			}
		}else {
			autenticarEmailView.exibeMensagemInformativa("Digite o c�digo recebido!");
		}
		
		em.getTransaction().commit();
	
	}
	
	private void criptografarSenha(ModelUsuario usuario) {
		usuario.setSenhaUsuario(Criptografar.criptografar(usuario.getSenhaUsuario()));
	}

	private void irParaTelaInicial(ModelUsuario usuario) {
		SenhasView telaInicial = new SenhasView(usuario);
		telaInicial.setLocationRelativeTo(null);
		telaInicial.setResizable(false);
		telaInicial.setVisible(true);
	}

	public void sair() {
		autenticarEmailView.dispose();
	}
	
}
