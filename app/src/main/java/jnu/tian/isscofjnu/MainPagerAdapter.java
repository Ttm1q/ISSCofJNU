package jnu.tian.isscofjnu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainPagerAdapter extends FragmentStateAdapter {

    public MainPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // 根据位置返回对应的 Fragment
        switch (position) {
            case 0:
                return new FacultyFragment();
            case 1:
                return new TutorFragment();
            case 2:
                return new MapFragment();
            default:
                return new FacultyFragment();
        }
    }

    @Override
    public int getItemCount() {
        // 返回 Fragment 的数量
        return 3;
    }
}

