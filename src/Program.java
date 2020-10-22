import automatosFinitos.EntradaIndefinidaException;
import automatosFinitos.deterministico.AFD;
import automatosFinitos.deterministico.EstadoAFD;

public class Program {
    public static void main(String[] args) throws EntradaIndefinidaException {
        String[] alfabeto = {"0", "1"};
        AFD afd = new AFD(alfabeto);
        EstadoAFD q0 = afd.getEstadoInicial();
        EstadoAFD q1 = afd.novoEstado();
        q1.setFuncaoTransicao("0", q0);
        q1.setFuncaoTransicao("1", q0);
        q0.setFuncaoTransicao("0", q1);
        q0.setFuncaoTransicao("1", q1);
        q1.setFinal(true);
        System.out.println(afd.aceitaPalavra("0101"));
    }
}
