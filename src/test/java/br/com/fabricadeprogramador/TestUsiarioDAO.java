package br.com.fabricadeprogramador;

import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestUsiarioDAO {
	public static void main(String[] args) {
		testBuscarTodos();
	}
	
	private static void testBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(5);
		System.out.println(usuario);
	}
	
	private static void testBuscarTodos() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscarTodos();
		for(Usuario u:lista){
			System.out.println(u);
		}
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
	
	public static void testSalvar(){
		Usuario usuario = new Usuario();
		//usuario.setId(1);
		usuario.setNome("Denis");
		usuario.setLogin("denis");
		usuario.setSenha("123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);
		
		System.out.println("Salvo com sucesso!");
	}
}
