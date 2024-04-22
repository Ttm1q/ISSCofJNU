package jnu.tian.isscofjnu;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;


public class TutorDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_detail);

        // 获取传入的参数
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("tutor")) {
            String discipline = intent.getStringExtra("tutor");
            TextView textView = findViewById(R.id.textView_content_tutor);
            // 根据参数设置文本内容
            switch (discipline) {
                case "导师1":
                    textView.setText("导师1的内容");
                    break;
                case "导师2":
                    textView.setText("导师2的内容");
                    break;
                case "导师3":
                    textView.setText("导师3的内容");
                    break;
                default:
                    textView.setText("其他导师的内容");
                    break;
            }
        }
    }
}