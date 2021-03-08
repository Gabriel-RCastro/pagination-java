import java.util.List;
import java.util.function.BiConsumer;

public class Paginacao {
    private int quantidadePorPagina;
    private List<?> itens;
    private BiConsumer<List<?>, Integer> consumer;

    public Paginacao() {
    }

    public Paginacao qtdPorPagina(int quantidadePorPagina) {
        this.quantidadePorPagina = quantidadePorPagina;
        return this;
    }

    public Paginacao itens(List<?> itens) {
        this.itens = itens;
        return this;
    }

    public Paginacao executarCadaPagina(BiConsumer<List<?>, Integer> consumer) {
        this.consumer = consumer;
        return this;
    }

    public void paginar() {
        var totalDeItens = itens.size();
        var totalDePaginas = quantidadePorPagina > 0 ? (totalDeItens - 1) / quantidadePorPagina + 1 : 0;
        for (int i = 0; i < totalDePaginas; i++) {
            var inicio = i * quantidadePorPagina;
            var fim = (i + 1) * quantidadePorPagina;
            if (fim > totalDeItens) fim = totalDeItens;
            var listaDeResultados = itens.subList(inicio, fim);
            this.consumer.accept(listaDeResultados, i);
        }
    }
}