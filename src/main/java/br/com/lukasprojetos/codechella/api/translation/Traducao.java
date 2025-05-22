package br.com.lukasprojetos.codechella.api.translation;

import java.util.List;

public record Traducao(List<Texto> translations) {
    public String geTexto(){
        return translations.get(0).text();
    }

}
