package com.example.android3;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URI;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int item_type = 0;
    private final Context cont;
    private final List<Object> listRcvItems;
    private DataObject dataObject;
    private static final int PERMISSION_STORAGE_CODE = 1000;
    public RecyclerViewAdapter(Context context, List<Object> rcv){
        this.cont = context;
        this.listRcvItems = rcv;
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder{
        private   TextView txt_title;
        private TextView txt_level;
        private   TextView txt_info;
        private TextView txt_author;
        private  ImageView txt_image;
        private Button Btn;

        MenuItemViewHolder(View view){
            super(view);
            txt_title = (TextView) view.findViewById(R.id.txt_title);
            txt_level = (TextView) view.findViewById(R.id.txt_level);
            txt_info = (TextView) view.findViewById(R.id.txt_info);
            txt_author = (TextView) view.findViewById(R.id.txt_author);
            txt_image = (ImageView) view.findViewById(R.id.txt_img);
            Btn = (Button) view.findViewById(R.id.Btn);
        }
    }

    @Override
    public int getItemCount() {
        return listRcvItems.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View menuItemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.container_list,parent,false);
        return new MenuItemViewHolder(menuItemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder _holder, int position) {
        int ViewType = getItemViewType(position);
        switch (ViewType){
            case item_type:
                default:
                    final MenuItemViewHolder menuHolder = (MenuItemViewHolder) _holder;
                    DataObject obj = (DataObject) mRecyclerViewItems.get(position);

                    String title = obj.getTitle();
                    String Image = obj.getImage();
                    int ImgID = context.getResources().getIdentifier(Image,"drawable",cont.getPackageName());

                    menuHolder.txt_title.setText(dataObject.getTitle());


                    menuHolder.txt_author.setText(dataObject.getAuthor());
                    menuHolder.txt_info.setText(dataObject.getInfo());
                    menuHolder.txt_level.setText(dataObject.getLevel());

                    menuHolder.txt_image.setImageResource(ImgID);

                    menuHolder.Btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(dataObject.getURL()));
                            context.startActivity(intent);
                        }
                    });

        }
    }
}
