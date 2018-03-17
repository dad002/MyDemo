package com.example.kolvir.test.Gallery;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kolvir.test.R;

import java.util.ArrayList;
import java.util.List;
// ЕБлан ускозадый

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PhotosViewHolder>{

    String TAGRV = "RVINFO";
    private List<Chapters> chaptersList = new ArrayList<>();

    public void addAll(List<Chapters> chapters){
        Log.i(TAGRV,"InAddAll");

        int pos = getItemCount();
        this.chaptersList.addAll(chapters);
        notifyItemRangeInserted(pos, this.chaptersList.size());
    }

    @NonNull
    @Override
    public RVAdapter.PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.i(TAGRV,"InRVAdapter");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent,false);
        return new RVAdapter.PhotosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.PhotosViewHolder holder, int position) {
        Log.i(TAGRV,"InBindViewHolder");
        holder.bind(chaptersList.get(position));
    }

    @Override
    public int getItemCount() {
        return chaptersList.size();
    }

    public class PhotosViewHolder extends RecyclerView.ViewHolder {

        private ImageView images = null;
        private TextView name = null;

        public PhotosViewHolder(View itemView) {
            super(itemView);
            Log.i(TAGRV,"InPhotosViewHolder");
            name = (TextView) itemView.findViewById(R.id.title);
            images = (ImageView) itemView.findViewById(R.id.image);
        }

        public void bind(Chapters chapters){
            images.setImageBitmap(BitmapFactory.decodeResource(itemView.getResources(), chapters.getImage()));
            name.setText(chapters.getName());
        }
    }
}