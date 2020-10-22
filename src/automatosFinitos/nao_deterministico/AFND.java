package automatosFinitos.nao_deterministico;

import java.util.ArrayList;
import java.util.Objects;

import automatosFinitos.AutomatoFinito;
import automatosFinitos.EntradaIndefinidaException;
import automatosFinitos.Estado;

public class AFND extends AutomatoFinito{
	
	private ArrayList<EstadoAFND> estados;

	public AFND(String[] alfabeto) {
		super(alfabeto);
		estados = new ArrayList<EstadoAFND>();
		EstadoAFND inicial = this.novoEstado();
		this.estadoInicial = inicial;
	}

	public EstadoAFND novoEstado() {
		EstadoAFND novo = new EstadoAFND();
		novo.setIndice(estados.size());
		this.estados.add(novo);
		return novo;
	}
	
	@Override
	public EstadoAFND getEstadoInicial() {
		return (EstadoAFND) estadoInicial;
	}
	
	public ArrayList<EstadoAFND> getEstados() {
		return this.estados;
	}

	@Override
	public boolean aceitaPalavra(String palavra) throws EntradaIndefinidaException {
		EstadoAFND estadoAtual = this.getEstadoInicial();
		for (int i = 0; i < palavra.length(); i++) {
			String entrada = "" + palavra.charAt(i);
			estadoAtual = estadoAtual.getResultadosTransicoes(entrada);
		}
		return estadoAtual.isFinal();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AFND afnd = (AFND) o;
		return Objects.equals(estados, afnd.estados);
	}

	@Override
	public int hashCode() {
		return Objects.hash(estados);
	}
}
