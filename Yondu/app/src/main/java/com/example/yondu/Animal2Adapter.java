package com.example.yondu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yondu.ui.Animal;

import java.util.ArrayList;

public class Animal2Adapter extends RecyclerView.Adapter<Animal2Adapter.AnimalViewHolder> {

    Context context;
    ArrayList<Animal> data;

        Animal2Adapter(Context context, ArrayList<Animal> data) {
        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public Animal2Adapter.AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View animalView = LayoutInflater.from(context).inflate(R.layout.animal2_item,parent,false);
        Animal2Adapter.AnimalViewHolder viewHolder = new AnimalViewHolder(animalView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Animal2Adapter.AnimalViewHolder holder, int position) {
            holder.setData(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tvname, tvdesc;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imageView4);
            tvname = itemView.findViewById(R.id.textView6);
            tvdesc =  itemView.findViewById(R.id.textView7);
            //itemView.setOnClickListener();
            for(Animal one : data){
                setData(one);
            }

        }
        public void setData(Animal one){
            iv.setImageResource(one.getImageid());
            tvname.setText(one.getName());
            tvdesc.setText(one.getName2());
    }
}
}
