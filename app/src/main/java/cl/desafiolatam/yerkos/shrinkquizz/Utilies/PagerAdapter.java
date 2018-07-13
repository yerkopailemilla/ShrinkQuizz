package cl.desafiolatam.yerkos.shrinkquizz.Utilies;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import cl.desafiolatam.yerkos.shrinkquizz.Fragments.MatchFragment;
import cl.desafiolatam.yerkos.shrinkquizz.Fragments.LuckyFragment;
import cl.desafiolatam.yerkos.shrinkquizz.Fragments.PartyFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int tabs) {
        super(fm);
        this.numberOfTabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new PartyFragment();
            case 1:
                return new MatchFragment();
            case 2:
                return new LuckyFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
