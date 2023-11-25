package org.app;

public enum Especialidad {
	SUSPENSO("Suspenso"),
	CIENCIAFICCION("Ciencia Ficción"),
	TERROR("Terror"),
	AUTOAYUDA("Auto Ayuda");
	private String categoria;

	private Especialidad(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return this.categoria;
	}
}