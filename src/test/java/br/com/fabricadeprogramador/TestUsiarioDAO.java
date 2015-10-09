package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestUsiarioDAO {
	public static void main(String[] args) {
		testExcluir();
	}
	
	public static void testCadastrar(){
		Usuario usu = new Usuario();
		usu.setNome("Danilo");
		usu.setLogin("danilo");
		usu.setSenha("123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		
		System.out.println("Cadastrado com sucesso!");
	}
	
	public static void testAlterar(){
		Usuario usu = new Usuario();
		usu.setId(3);
		usu.setNome("Danilo Rodrigues");
		usu.setLogin("danilo");
		usu.setSenha("123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
		
		System.out.println("Alterado com sucesso!");
	}
	
	public static void testExcluir(){
		Usuario usu = new Usuario();
		usu.setId(4);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		
		System.out.println("Excluir com sucesso!");
	}
}
