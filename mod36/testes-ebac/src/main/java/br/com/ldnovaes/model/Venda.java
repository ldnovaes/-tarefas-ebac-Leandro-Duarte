package br.com.ldnovaes.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_VENDA")
@Builder
@Getter
@Setter
public class Venda implements Persistente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo_produto")
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", foreignKey = @ForeignKey(name="fk_venda_cliente"), referencedColumnName = "id", nullable = false)
	private Cliente cliente;
	
	@Column(name="quantidade")
	private Integer quantidade;
	
	@ManyToMany
	@JoinTable(name = "venda_produto",
               joinColumns = @JoinColumn(name = "venda_id"),
               inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produtos;

}
