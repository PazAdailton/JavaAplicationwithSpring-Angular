package br.com.pazimportss.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Estudante {
	
	@Id @GeneratedValue
	private Integer id;
	private String nome;
	private String email;
	private String categoriaEstudantil;
	
	
	
	public Estudante() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategoriaEstudantil() {
		return categoriaEstudantil;
	}

	public void setCategoriaEstudantil(String categoriaEstudantil) {
		this.categoriaEstudantil = categoriaEstudantil;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoriaEstudantil, email, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		return Objects.equals(categoriaEstudantil, other.categoriaEstudantil) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Estudante [id=" + id + ", nome=" + nome + ", email=" + email + ", categoriaEstudantil="
				+ categoriaEstudantil + "]";
	}
	
	
}
