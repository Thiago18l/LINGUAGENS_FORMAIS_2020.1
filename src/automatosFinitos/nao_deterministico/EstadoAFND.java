package automatosFinitos.nao_deterministico;

import java.util.ArrayList;
import java.util.Map;

import automatosFinitos.AbstractEstado;
import automatosFinitos.EntradaIndefinidaException;
import automatosFinitos.deterministico.EstadoAFD;


public class EstadoAFND extends AbstractEstado{
	private Map<String, EstadoAFND> funcoesTransicao;
	private ArrayList<String> chaves;
	private ArrayList<EstadoAFND> resultadosTransicoes;
	public static final String EPSILON = "EPSILON";
	
	public EstadoAFND(){
		chaves = new ArrayList<String>();
		resultadosTransicoes = new ArrayList<EstadoAFND>();
	}
	public Map<String, EstadoAFND> getFuncoesTransicao () {
		return funcoesTransicao;
	}
	public void setFuncaoTransicao(String entrada, EstadoAFND estadoResutante) {
		chaves.add(entrada);
		resultadosTransicoes.add(estadoResutante);
	}
	
	public void setTransicaoEpsilon(EstadoAFND estadoResultante) {
		chaves.add(EPSILON);
		resultadosTransicoes.add(estadoResultante);
	}
	
	public void removeFuncaoTransicao(String entrada, AbstractEstado estadoResutante){
		for(int i = 0; i < chaves.size(); i++){
			if(chaves.get(i).equals(entrada) && resultadosTransicoes.get(i).equals(estadoResutante)){
				chaves.remove(i);
				resultadosTransicoes.remove(i);
				return;
			}
		}
	}
	
	public ArrayList<String> getChaves() {
		return chaves;
	}

	public EstadoAFND getResultadoFuncaoTransicao(String entrada) throws EntradaIndefinidaException {
		if(!funcoesTransicao.containsKey(entrada)) throw new EntradaIndefinidaException(entrada);
		return this.getFuncoesTransicao().get(entrada);
	}
	
	public ArrayList<EstadoAFND> getResultadosTransicoes() {
		return resultadosTransicoes;
	}
	public EstadoAFND getResultadosTransicoes (String palavra) throws EntradaIndefinidaException {
		if (!resultadosTransicoes.contains(palavra)) throw new EntradaIndefinidaException(palavra);
		return this.getResultadosTransicoes().get(Integer.parseInt(palavra));
	}

}