package presto.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name = "Endereco")
public class Endereco {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id")
		private Long id;
		
	    @Column (name="logadouro")
		private String logadouro;
		
	    @Column (name="numero")
		private int numero;
	    
	    @Column (name="cep")
		private int cep;
	    
	    @Column (name="cidade")
		private String cidade;
	
	    @Column (name="bairro")
		private String bairro;
	    
	    @Column (name="pais")
		private String pais;
		
	    @OneToOne(mappedBy = "endereco", targetEntity = Cliente.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JsonIgnore
	    private Cliente cliente;
	    
	    @OneToOne(mappedBy = "endereco", targetEntity = Prestador.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JsonIgnore	
	    private Prestador prestador;
	
		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
	
		public String getLogadouro() {
			return logadouro;
		}
	
		public void setLogadouro(String logadouro) {
			this.logadouro = logadouro;
		}
	
		public int getNumero() {
			return numero;
		}
	
		public void setNumero(int numero) {
			this.numero = numero;
		}
	
		public int getCep() {
			return cep;
		}
	
		public void setCep(int cep) {
			this.cep = cep;
		}
	
		public String getCidade() {
			return cidade;
		}
	
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
	
		public String getBairro() {
			return bairro;
		}
	
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
	
		public String getPais() {
			return pais;
		}
	
		public void setPais(String pais) {
			this.pais = pais;
		}
	
		public Cliente getCliente() {
			return cliente;
		}
	
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
	
		public Prestador getPrestador() {
			return prestador;
		}
	
		public void setPrestador(Prestador prestador) {
			this.prestador = prestador;
		}
	 
    
}
