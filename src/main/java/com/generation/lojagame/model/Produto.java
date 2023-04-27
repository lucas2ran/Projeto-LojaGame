package com.generation.lojagame.model;

import java.math.BigDecimal;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do produto é obrigatorio!")
	@Size(min = 5, max = 255, message = "O atributo nome deve conter no mínimo 05 e no máximo 255 caracteres")
	private String nome;
	
	@NotBlank(message = "O valor do produto é obrigatório!")
	@Size(min = 5, max = 1000, message = "O atributo descrição deve conter no mínimo 05 e no máximo 1000 caracteres")
	private String genero;
	
	@NotNull(message = "O valor é obrigatório!")
    @DecimalMin(value = "0.01", message = "O preço do produto precisa ser um valor positivo e acima de R$ 5,00")
    private BigDecimal valor;
	

	@ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}