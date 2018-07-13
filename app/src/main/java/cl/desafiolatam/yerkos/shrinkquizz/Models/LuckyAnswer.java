package cl.desafiolatam.yerkos.shrinkquizz.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LuckyAnswer {

    private boolean check;
    private boolean luckyDay;

    public LuckyAnswer(boolean check) {
        this.check = check;
        this.luckyDay = new LuckyDate().currentDay();
    }

    public boolean isCheck() {
        return check;
    }

    public boolean isLuckyDay() {
        return luckyDay;
    }

    private class LuckyDate {

        private boolean currentDay() {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
            int day = Integer.parseInt(simpleDateFormat.format(date));

            if(day == 0){
                return true;
            } else {
                return false;
            }

        }

    }

}
