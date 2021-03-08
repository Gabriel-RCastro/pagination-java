import java.util.ArrayList;
import java.util.List;

public class PaginacaoService {
    public static void main(String[] args) {
        var ad1 = Ad.of("id1", "anuncio1");
        var ad2 = Ad.of("id2", "anuncio2");
        var ad3 = Ad.of("id3", "anuncio3");
        var ad4 = Ad.of("id4", "anuncio4");
        var listaDeAds = new ArrayList<>(List.of(ad1, ad2, ad3, ad4));
        var quantidadePorPagina = 2;
        var totalDeAds = listaDeAds.size();
        var paginacao = new Paginacao();
        paginacao.qtdPorPagina(quantidadePorPagina)
                .itens(totalDeAds)
                .consultar(numeroDaPagina -> {
                    var inicio = numeroDaPagina * quantidadePorPagina;
                    var fim = (numeroDaPagina + 1) * quantidadePorPagina;
                    if (fim > totalDeAds) fim = totalDeAds;
                    return listaDeAds.subList(inicio, fim);
                })
                .executarCadaPagina((ads, paginaAtual) -> System.out.println("Página " + paginaAtual + " - Itens: " + ads))
                .paginar();
    }
}
