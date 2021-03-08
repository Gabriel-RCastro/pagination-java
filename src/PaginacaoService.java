import java.util.ArrayList;
import java.util.List;

public class PaginacaoService {
    public static void main(String[] args) {
        var ad1 = Ad.of("id1", "anuncio1");
        var ad2 = Ad.of("id2", "anuncio2");
        var ad3 = Ad.of("id3", "anuncio3");
        var ad4 = Ad.of("id4", "anuncio4");
        var listaDeAds = new ArrayList<>(List.of(ad1, ad2, ad3, ad4));
        Paginacao paginacao = new Paginacao();
        paginacao.qtdPorPagina(2)
                .itens(listaDeAds)
                .executarCadaPagina((ads, numeroDaPagina) -> System.out.println("Página " + numeroDaPagina + " - Itens: " + ads))
                .paginar();
    }
}
