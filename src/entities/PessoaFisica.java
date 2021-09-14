package entities;

public class PessoaFisica extends Pessoa {
	private Double gastosComSaudde;

	public PessoaFisica(String name, Double rendaAnual, Double gastosComSaudde) {
		super(name, rendaAnual);
		this.gastosComSaudde = gastosComSaudde;
	}

	public Double getGastosComSaudde() {
		return gastosComSaudde;
	}

	public void setGastosComSaudde(Double gastosComSaudde) {
		this.gastosComSaudde = gastosComSaudde;
	}

	@Override
	public double calculaValordoImposto() {
		if (super.getRendaAnual() < 20000.00) {
			return (this.getGastosComSaudde() > 0) ? this.getRendaAnual() * 0.15 - this.getGastosComSaudde() * 0.5 : this.getRendaAnual() * 0.15;
		} else {
			return (this.getGastosComSaudde() > 0) ? this.getRendaAnual() * 0.25 - this.getGastosComSaudde() * 0.5 : this.getRendaAnual() * 0.25;
		}
	}

}
