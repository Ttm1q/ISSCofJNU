package jnu.tian.isscofjnu.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import jnu.tian.isscofjnu.R;


public class DisciplineFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_discipline, container, false);
        recyclerView = root.findViewById(R.id.recycler_view_discipline);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> disciplineList = Arrays.asList("人工智能专业", "物联网专业", "工业工程专业"); // 专业列表
        DisciplineAdapter adapter = new DisciplineAdapter(disciplineList);
        recyclerView.setAdapter(adapter);
        return root;
    }

    private class DisciplineAdapter extends RecyclerView.Adapter<DisciplineAdapter.ViewHolder> {
        private List<String> disciplineList;

        public DisciplineAdapter(List<String> disciplineList) {
            this.disciplineList = disciplineList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discipline, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String discipline = disciplineList.get(position);
            holder.textView.setText(discipline);
            holder.itemView.setOnClickListener(v -> {
                // 根据点击的专业跳转到相应的界面
                Intent intent = new Intent(getActivity(), DisciplineDetailActivity.class);
                intent.putExtra("discipline", discipline);
                startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return disciplineList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.text_discipline);
            }
        }
    }
}
