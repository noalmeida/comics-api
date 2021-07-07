package com.challenge.crm.model;


import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;




public class Comics {
	@JsonProperty("id")
	private Long id_comics;
	@JsonProperty("title")
	private String titulo;
	@JsonProperty("preços")
	private ArrayList<Precos> precos;
	@JsonProperty("criadores ")
	private String autores;
	@JsonProperty("descrição")
	private String descricao;
	@JsonProperty("isbn") 
	private String isbn;
	public Long getId_comics() {
		return id_comics;
	}
	public void setId_comics(Long id_comics) {
		this.id_comics = id_comics;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<Precos> getPreco() {
		return precos;
	}
	public void setPreco(ArrayList<Precos> precos) {
		this.precos = precos;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_comics, isbn, precos);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comics other = (Comics) obj;
		return Objects.equals(id_comics, other.id_comics) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(precos, other.precos);
	}
	
	
	
	

}
