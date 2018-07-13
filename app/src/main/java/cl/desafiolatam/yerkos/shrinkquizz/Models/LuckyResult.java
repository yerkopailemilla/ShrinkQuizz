package cl.desafiolatam.yerkos.shrinkquizz.Models;

public class LuckyResult extends LuckyAnswer {

    public LuckyResult(boolean check) {
        super(check);
    }

    public String estaCheck(){
        boolean answer = isCheck();
        if (answer){
            return "Esa es la actitud";
        } else {
            return "Animate";
        }
    }

    private String processing(){
        boolean answer = isLuckyDay();
        if (answer){
            return "y es tu dia de suerte!";
        } else {
            return "vendrán tiempos mejores!:)";
        }
    }
}
