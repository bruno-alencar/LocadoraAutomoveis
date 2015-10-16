package br.usjt.arqdesis.model;

import java.sql.Date;

public class Cliente {
	
	private Long codigo;
	private String nome;
	private int cpf;
	private int rg;
	private int telefone;
	private String email;
	private Date data_nascimento;
	private String sexo;
	private int cnh;
	private String estado_emissor_cnh;
	private Date validade_cnh;
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getCnh() {
		return cnh;
	}
	public void setCnh(int cnh) {
		this.cnh = cnh;
	}
	public String getEstado_emissor_cnh() {
		return estado_emissor_cnh;
	}
	public void setEstado_emissor_cnh(String estado_emissor_cnh) {
		this.estado_emissor_cnh = estado_emissor_cnh;
	}
	public Date getValidade_cnh() {
		return validade_cnh;
	}
	public void setValidade_cnh(Date validade_cnh) {
		this.validade_cnh = validade_cnh;
	}
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg
				+ ", telefone=" + telefone + ", email=" + email
				+ ", data_nascimento=" + data_nascimento + ", sexo=" + sexo
				+ ", cnh=" + cnh + ", estado_emissor_cnh=" + estado_emissor_cnh
				+ ", validade_cnh=" + validade_cnh + "]";
	}
	
}
