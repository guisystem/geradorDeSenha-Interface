package rocha.guilherme.jose.model.dao;

import java.util.ArrayList;

import rocha.guilherme.jose.model.ModelSenhasSalvas;
import rocha.guilherme.jose.model.ModelUsuario;

public class BancoDeDados {

    public static ArrayList<ModelUsuario> usuarios;
    public static ArrayList<ModelSenhasSalvas> senhas;

    public static void inicia(){
    	
    	usuarios = new ArrayList<>();
    	senhas = new ArrayList<>();
        
    	 ModelUsuario usuario1 = new ModelUsuario(1, "gui", "gui", "guilherme@gmail.com");
         
         ModelSenhasSalvas senha1 = new ModelSenhasSalvas(1, "Senha1", "Netflix", usuario1);
         ModelSenhasSalvas senha2 = new ModelSenhasSalvas(2, "Senha2", "", usuario1);
         
         usuario1.getSenhasSalvas().add(senha1);
         usuario1.getSenhasSalvas().add(senha2);
         
         usuarios.add(usuario1);
         
         senhas.add(senha1);
         senhas.add(senha2);
    	
    }
}
