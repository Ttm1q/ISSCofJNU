package jnu.tian.isscofjnu;

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


public class TutorFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tutor, container, false);
        recyclerView = root.findViewById(R.id.recycler_view_tutor);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> tutorList = Arrays.asList("导师1", "导师2", "导师3","导师4","导师5"); // 专业列表
        TutorFragment.TutorAdapter adapter = new TutorFragment.TutorAdapter(tutorList);
        recyclerView.setAdapter(adapter);
        return root;
    }

    private class TutorAdapter extends RecyclerView.Adapter<TutorFragment.TutorAdapter.ViewHolder> {
        private List<String> tutorList;

        public TutorAdapter(List<String> tutorList) {
            this.tutorList = tutorList;
        }

        @NonNull
        @Override
        public TutorFragment.TutorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutor, parent, false);
            return new TutorFragment.TutorAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TutorFragment.TutorAdapter.ViewHolder holder, int position) {
            String tutor = tutorList.get(position);
            holder.textView.setText(tutor);
            holder.itemView.setOnClickListener(v -> {
                // 根据点击的专业跳转到相应的界面
                Intent intent = new Intent(getActivity(), TutorDetailActivity.class);
                intent.putExtra("tutor", tutor);
                startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return tutorList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.text_tutor);
            }
        }
    }
}