package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario usu){
		String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usu) {
		String sql = "UPDATE usuario SET nome=?, login=?, senha=? WHERE id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluir(Usuario usu) {
		String sql = "DELETE FROM usuario WHERE id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, usu.getId());
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salvar(Usuario usuario){
		if(usuario.getId()!=null && usuario.getId()!=0){
			alterar(usuario);
		}else{
			cadastrar(usuario);
		}
	}
	
	/**
	 * Busca de um registro no banco de dados pelo ID do usuário
	 * @param id É um inteiro que representa o número do ID do usuário a ser buscado
	 * @return Um objeto usuário ou Null quando não há registro
	 */
	public Usuario buscarPorId(Integer id){
		String sql = "SELECT * FROM usuario WHERE id = ?";

		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();
			if(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				return usuario;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Realiza a busca de todos os registros dos usuários
	 * @return Uma lista de objetos usuário
	 */
	public List<Usuario> buscarTodos(){
		String sql = "SELECT * FROM usuario";
		List<Usuario> lista = new ArrayList<>();
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			
			ResultSet resultado = preparador.executeQuery();
			while(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				lista.add(usuario);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Usuario autenticar(Usuario usuConsulta){
		String sql = "SELECT * FROM usuario WHERE login=? AND senha=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usuConsulta.getLogin());
			preparador.setString(2, usuConsulta.getSenha());
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				return usuario;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
