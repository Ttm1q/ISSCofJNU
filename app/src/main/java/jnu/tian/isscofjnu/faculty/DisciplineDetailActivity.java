package jnu.tian.isscofjnu.faculty;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import jnu.tian.isscofjnu.databinding.ActivityDisciplineDetailBinding;

import jnu.tian.isscofjnu.R;

public class DisciplineDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discipline_detail);

        // 获取传入的参数
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("discipline")) {
            String discipline = intent.getStringExtra("discipline");
            TextView textView = findViewById(R.id.textView_content);
            // 根据参数设置文本内容
            switch (discipline) {
                case "人工智能专业":
                    textView.setText("人工智能专业的内容");
                    break;
                case "物联网专业":
                    textView.setText("物联网专业的内容");
                    break;
                case "工业工程专业":
                    textView.setText("工业工程专业的内容");
                    break;
                default:
                    textView.setText("其他专业的内容");
                    break;
            }
        }
    }
}
