package model.entidades;

public class Questionario {
    
    private String perguntaPessoal;
    private String perguntaRisco;
    private String perguntaHorizonteTempo;
    private String perguntaPrazo;

    public Questionario(String perguntaPessoal, String perguntaRisco, String perguntaHorizonteTempo, String perguntaPrazo) {
        this.perguntaPessoal = perguntaPessoal;
        this.perguntaRisco = perguntaRisco;
        this.perguntaHorizonteTempo = perguntaHorizonteTempo;
        this.perguntaPrazo = perguntaPrazo;
    }

    public String getPerguntaPessoal() {
        return perguntaPessoal;
    }

    public void setPerguntaPessoal(String perguntaPessoal) {
        this.perguntaPessoal = perguntaPessoal;
    }

    public String getPerguntaRisco() {
        return perguntaRisco;
    }

    public void setPerguntaRisco(String perguntaRisco) {
        this.perguntaRisco = perguntaRisco;
    }

    public String getPerguntaHorizonteTempo() {
        return perguntaHorizonteTempo;
    }

    public void setPerguntaHorizonteTempo(String perguntaHorizonteTempo) {
        this.perguntaHorizonteTempo = perguntaHorizonteTempo;
    }

    public String getPerguntaPrazo() {
        return perguntaPrazo;
    }

    public void setPerguntaPrazo(String perguntaPrazo) {
        this.perguntaPrazo = perguntaPrazo;
    }
    
    
    
    
}
