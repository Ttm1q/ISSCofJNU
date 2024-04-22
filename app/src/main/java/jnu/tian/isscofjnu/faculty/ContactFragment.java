package jnu.tian.isscofjnu.faculty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jnu.tian.isscofjnu.R;

public class ContactFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);inflater.inflate(R.layout.fragment_history, container, false);
        TextView textView = view.findViewById(R.id.textview_contact);
        textView.setText("地址：广东省珠海市香洲区前山路206号暨南大学行政楼6楼\n" +
                "\n" +
                "  \n" +
                "\n" +
                "电话：0756-8505610\n" +
                "\n" +
                "  \n" +
                "\n" +
                "邮箱：osisse@jnu.edu.cn\n" +
                "\n" +
                " ");
        return view;
    }
}