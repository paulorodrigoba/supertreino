package br.com.supertreino.api.model;

public record DadosDetalhamentoExercicio(Long id, String nomeExercicio, GrupoMuscular grupoMuscular) {
    public DadosDetalhamentoExercicio(Exercicio exercicio) {
        this(exercicio.getId(), exercicio.getNomeExercicio(), exercicio.getGrupoMuscular());
    }
}
