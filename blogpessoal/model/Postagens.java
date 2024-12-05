package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // cria tabela
@Table(name = "tb_postagens") // da nome a tabela
public class Postagens {

	@Id // define como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // define o auto_increment
	private Long id;

	@NotBlank // igual o not null só que não permite espaços em branco
	@Size(min = 5, max = 100) // tamanho dos caracteres
	private String titulo;

	@NotBlank
	@Size(min = 10, max = 1000)
	private String texto;

	@UpdateTimestamp // define hora e data para quando fizer o post, em tempo real
	private LocalDateTime data;

	@ManyToOne // tabela relacionamento de muitos para um
	@JsonIgnoreProperties("postagem") // ignora as postagens que estão relacionados ao tema, evita loop
	private Tema tema; // está referenciando o objeto tema

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
