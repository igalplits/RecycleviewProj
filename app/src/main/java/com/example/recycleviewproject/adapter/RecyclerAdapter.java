package com.example.recycleviewproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewproject.R;
import com.example.recycleviewproject.model.RecyclerModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List <RecyclerModel> recycleModels;
    public RecyclerAdapter(Context context,List <RecyclerModel> recycleModels) {
        this.context = context;
        this.recycleModels = recycleModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.items_recycler,parent,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtDate.setImageResource(recycleModels.get(position).getDate());
        holder.txtTitle.setText(recycleModels.get(position).getTitle());
        holder.txtDescription.setText(recycleModels.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return recycleModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle,txtDescription;
        private ImageView txtDate;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDate= itemView.findViewById(R.id.txt_date);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDescription = itemView.findViewById(R.id.txt_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Show a message when the item is clicked
                    String message = "Clicked item: " + txtTitle.getText().toString();
                    Drawable imageDrawable = txtDate.getDrawable();
                    showCustomToast(v,message,imageDrawable);


//                     Snackbar.make(v, message, Snackbar.LENGTH_LONG).show();
                }
            });

        }

    }

    public void setFilteredList(List<RecyclerModel> filteredList)
    {
        this.recycleModels = filteredList;
        notifyDataSetChanged();
    }
    private void showCustomToast(View view, String message, Drawable imageResId) {
        // Inflate the custom Toast layout
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customToastView = inflater.inflate(R.layout.items_recycler, null);

        // Set image in the Toast
        ImageView toastImage = customToastView.findViewById(R.id.txt_date);
        toastImage.setImageDrawable(imageResId);

        // Set text in the Toast
        TextView toastText = customToastView.findViewById(R.id.txt_title);
        toastText.setText(message);

        TextView toastDescroption = customToastView.findViewById(R.id.txt_description);
        toastDescroption.setText("");

        customToastView.setBackgroundColor(Color.parseColor("#FF5722"));

        // Create and show the Toast
        Toast toast = new Toast(view.getContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(customToastView);
        toast.show();
    }
}
