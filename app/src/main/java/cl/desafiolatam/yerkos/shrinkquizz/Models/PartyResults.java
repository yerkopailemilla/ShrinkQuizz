package cl.desafiolatam.yerkos.shrinkquizz.Models;

public class PartyResults extends PartyAnswer {

    public PartyResults(String answer) {
        super(answer);
    }

    private String processing(){
        String answer = getAnswer();
        if (answer.contains("5")){
            return "Eres un niño";
        } else if (answer.contains("10")){
            return "Bien, dale campeón";
        } else {
            return "Necesitas ayuda";
        }
    }

    public String score(){
        return processing();
    }
}
