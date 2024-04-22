package jnu.tian.isscofjnu.faculty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jnu.tian.isscofjnu.R;

public class LeaderFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leader, container, false);
        TextView textView = view.findViewById(R.id.textview_leader);
        textView.setText("杨光华：院长，负责学院全面工作；分管行政、人事、财务、高水平大学建设等工作；联系物联网与物流工程研究院。\n" +
                "\n" +
                "周玉宇：党总支书记，负责学院党总支全面工作；分管党建、思政、意识形态、干部、宣传、监察、安全、保密、统战、工会等工作。\n" +
                "\n" +
                "陈韶鹏：党总支副书记，分管学生工作、信息化、竞赛基地、校友等工作。\n" +
                "\n" +
                "施  政：副院长，分管学科建设、科研、研究生教育、高级研修班、产学研合作平台、国际交流与合作等工作。\n" +
                "\n" +
                "闫  勉：副院长，分管本科教育、教师教学培训、实验室、实习/实践平台与基地、人工智能产业学院建设等工作。");
        return view;
    }
}