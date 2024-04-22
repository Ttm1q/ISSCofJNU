package jnu.tian.isscofjnu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import jnu.tian.isscofjnu.faculty.ContactFragment;
import jnu.tian.isscofjnu.faculty.DisciplineFragment;
import jnu.tian.isscofjnu.faculty.HistoryFragment;
import jnu.tian.isscofjnu.faculty.LeaderFragment;

public class FacultyFragment extends Fragment {
    private String[] tabHeaderStrings = {"学院介绍","专业介绍","学院领导","联系我们"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        ViewPager2 viewPager = view.findViewById(R.id.view_pager);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);

        //创建适配器
        FragmentAdapter fragmentAdapter=new FragmentAdapter(getChildFragmentManager(), getLifecycle());
        viewPager.setAdapter(fragmentAdapter);

        //将TabLayout和ViewPager2进行关联
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(tabHeaderStrings[position]);
        }).attach();

        return view;
    }

    public static class FragmentAdapter extends FragmentStateAdapter {
        private static final int NUM_TABS = 4;

        public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // 根据位置返回对应的Fragment实例
            switch (position) {
                case 0:
                    return new HistoryFragment();
                case 1:
                    return new DisciplineFragment();
                case 2:
                    return new LeaderFragment();
                case 3:
                    return new ContactFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return NUM_TABS;
        }
    }
}
