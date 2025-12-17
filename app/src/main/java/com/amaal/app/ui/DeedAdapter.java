package com.amaal.app.ui;

import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import com.amaal.app.R;
import com.amaal.app.data.*;
import java.util.*;

public class DeedAdapter extends RecyclerView.Adapter<DeedAdapter.Holder> {

    List<Deed> deeds;
    AppDatabase db;

    public DeedAdapter(List<Deed> d, AppDatabase db) {
        this.deeds = d;
        this.db = db;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        TextView title;
        CheckBox done;
        public Holder(View v) {
            super(v);
            title = v.findViewById(R.id.deedTitle);
            done = v.findViewById(R.id.deedCheck);
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup p, int v) {
        return new Holder(LayoutInflater.from(p.getContext())
            .inflate(R.layout.item_deed, p, false));
    }

    @Override
    public void onBindViewHolder(Holder h, int i) {
        Deed d = deeds.get(i);
        h.title.setText(d.title);
        h.done.setChecked(d.completedToday);

        h.done.setOnClickListener(v -> {
            d.completedToday = h.done.isChecked();
            db.deedDao().update(d);
        });

        h.itemView.setOnLongClickListener(v -> {
            if (d.isPrayer) {
                PrayerConfigDialog.show(v.getContext(), d, db);
                return true;
            }
            return false;
        });
    }

    @Override
    public int getItemCount() { return deeds.size(); }
}