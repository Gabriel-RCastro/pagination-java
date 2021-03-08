import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Paginacao {
    private int quantidadePorPagina;
    private int totalDeItens;
    private Function<Integer, List<?>> consulta;
    private BiConsumer<List<?>, Integer> executa;

    public Paginacao() {
    }

    public Paginacao qtdPorPagina(int quantidadePorPagina) {
        this.quantidadePorPagina = quantidadePorPagina;
        return this;
    }

    public Paginacao itens(int totalDeItens) {
        this.totalDeItens = totalDeItens;
        return this;
    }

    public Paginacao consultar(Function<Integer, List<?>> consulta) {
        this.consulta = consulta;
        return this;
    }

    public Paginacao executarCadaPagina(BiConsumer<List<?>, Integer> executa) {
        this.executa = executa;
        return this;
    }

    public void paginar() {
        var totalDePaginas = quantidadePorPagina > 0 ? (totalDeItens - 1) / quantidadePorPagina + 1 : 0;
        for (int i = 0; i < totalDePaginas; i++) {
            var listaDeResultados = this.consulta.apply(i);
            this.executa.accept(listaDeResultados, i);
        }
    }
}