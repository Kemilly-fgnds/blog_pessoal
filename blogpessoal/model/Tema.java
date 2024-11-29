package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_temas")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O Atributo Descrição é obrigatório")
	private String descricao;
	// Cascade: Tudo que tiver relacionado aquela tema e nao tiver mais, irá apagar.
	// Lazy: busca preguiçosamente os dados que especificamos
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tema", cascade = CascadeType.REMOVE) // relacionamento de 1 para
																						// muitos, o contrário do outro
	@JsonIgnoreProperties("tema") // ignora os temas que estão relacionados as postagens, evita loop
	private List<Postagens> postagem; // Lista de temas das postagens

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagens> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagens> postagem) {
		this.postagem = postagem;
	}

}
