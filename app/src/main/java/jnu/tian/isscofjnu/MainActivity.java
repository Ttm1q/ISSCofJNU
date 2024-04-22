package jnu.tian.isscofjnu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // 创建 PagerAdapter
        MainPagerAdapter pagerAdapter = new MainPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        // 设置 BottomNavigationView 的监听器
        bottomNavigationView.setOnItemSelectedListener(item -> {
                    int id = item.getItemId();
                    if (id == R.id.menu_faculty) {
                        viewPager.setCurrentItem(0);
                        return true;
                    } else if (id == R.id.menu_tutor) {
                        viewPager.setCurrentItem(1);
                        return true;
                    } else if (id == R.id.menu_map) {
                        viewPager.setCurrentItem(2);
                        return true;
                    } else {
                        return false;
                    }
                });

        // 监听 ViewPager 的页面切换事件，同步更新 BottomNavigationView 的选中项
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.menu_faculty);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.menu_tutor);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.menu_map);
                        break;
                }
            }
        });
        Button buttonLoad = findViewById(R.id.button_load);
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 创建一个 Intent 对象，指定要启动的 Activity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                // 启动登录界面的 Activity
                startActivity(intent);
            }
        });
    }
}