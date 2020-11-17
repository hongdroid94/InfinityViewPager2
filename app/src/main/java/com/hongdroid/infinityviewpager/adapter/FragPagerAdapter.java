package com.hongdroid.infinityviewpager.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hongdroid.infinityviewpager.fragment.Frag1;
import com.hongdroid.infinityviewpager.fragment.Frag2;
import com.hongdroid.infinityviewpager.fragment.Frag3;

public class FragPagerAdapter extends FragmentStateAdapter {
    // Real Fragment Total Count
    private final int mSetItemCount = 3;

    public FragPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int iViewIdx = getRealPosition(position);
        switch( iViewIdx ) {
            case 0    : { return new Frag1(); }
            case 1    : { return new Frag2(); }
            case 2    : { return new Frag3(); }
            default   : { return new Frag1(); }
        }

    }

    public int getRealPosition(int _iPosition){
        return _iPosition % mSetItemCount;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
