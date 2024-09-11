package br.com.supertreino.api.model;

public record DadosListagemExercicio(Long id, String nomeExercicio, GrupoMuscular grupoMuscular) {
    public DadosListagemExercicio(Exercicio exercicio) {
        this(exercicio.getId(), exercicio.getNomeExercicio(), exercicio.getGrupoMuscular());
    }
}
