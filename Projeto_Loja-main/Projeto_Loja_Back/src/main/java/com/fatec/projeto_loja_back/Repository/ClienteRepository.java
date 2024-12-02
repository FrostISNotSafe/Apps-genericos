package com.fatec.projeto_loja_back.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.fatec.projeto_loja_back.Entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    // Método para login, buscando o cliente por email e senha
    @Query(value = "SELECT * FROM cliente WHERE email = ?1 AND senha = ?2", nativeQuery = true)
    Optional<Cliente> login(String email, String senha);

    // Método para recuperar a senha, buscando o cliente por email
    @Query(value = "SELECT * FROM cliente WHERE email = ?1", nativeQuery = true)
    Optional<Cliente> recuperaSenha(String email);

    // Método para buscar cliente por email, CPF ou RG
    @Query(value = "SELECT * FROM cliente WHERE email = ?1 OR cpf = ?2 OR rg = ?3", nativeQuery = true)
    Optional<Cliente> findByEmailCpfRg(String email, String cpf, String rg);

    // Método para buscar cliente por código, CPF, RG ou email
    @Query(value = "SELECT * FROM cliente WHERE codigo = ?1 OR cpf = ?1 OR rg = ?1 OR email = ?1", nativeQuery = true)
    Optional<Cliente> findByCodigoCpfRgEmail(String valor);
}
