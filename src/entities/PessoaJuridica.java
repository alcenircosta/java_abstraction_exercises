package entities;

public class PessoaJuridica extends Pessoa {
	private Integer numeroDeFuncionarios;

	public PessoaJuridica(String name, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(name, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public double calculaValordoImposto() {
		return (this.getNumeroDeFuncionarios() > 10) ? this.getRendaAnual() * 0.14 : this.getRendaAnual() * 0.16;
	}

}
