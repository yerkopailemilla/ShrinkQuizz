package cl.desafiolatam.yerkos.shrinkquizz.Models;

public class MatchResult extends MatchAnswer {

    public MatchResult(int userAge, int loverAge) {
        super(userAge, loverAge);
    }

    private String coupleAge(){

        int user = getUserAge();
        int lover = getLoverAge();

        if (user > lover){
            return "Tu eres mayor que tu pareja";
        } else if (user < lover){
            return "Tu pareja es mayor que tu";
        } else if(user == lover){
            return "Tienen la misma edad.";
        }

        return "";
    }

    public String showResult(){
        return coupleAge();
    }
}
