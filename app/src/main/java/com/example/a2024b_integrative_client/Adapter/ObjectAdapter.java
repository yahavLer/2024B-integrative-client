package com.example.a2024b_integrative_client.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2024b_integrative_client.ObjectCallback;
import com.example.a2024b_integrative_client.R;
import com.example.a2024b_integrative_client.model.object.ObjectBoundary;

import java.util.List;


public class ObjectAdapter extends RecyclerView.Adapter<ObjectAdapter.ObjectBoundaryViewHolder> {

    private List<ObjectBoundary> objectBoundaryList;
    private ObjectCallback objectCallback;

    public ObjectAdapter(List<ObjectBoundary> objectBoundaryList) {
        this.objectBoundaryList = objectBoundaryList;
    }
    public void setObjectCallback(ObjectCallback objectCallback) {
        this.objectCallback = objectCallback;
    }
    @NonNull
    @Override
    public ObjectBoundaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_object, parent, false);
        return new ObjectBoundaryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ObjectBoundaryViewHolder holder, int position) {
        ObjectBoundary object = objectBoundaryList.get(position);
        holder.object_alias.setText(object.getAlias());
        holder.object_location.setText(object.getLocation().toString());
        holder.object_datails.setText(object.getObjectDetails().toString());
        holder.object_id.setText(object.getObjectId().toString());
        holder.object_active.setText(object.getActive().toString());
        holder.object_createdBy.setText(object.getCreatedBy().toString());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (objectCallback != null) {
                    objectCallback.onObjectClick(object);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return objectBoundaryList.size();
    }

    public static class ObjectBoundaryViewHolder extends RecyclerView.ViewHolder {

        public TextView object_alias;
        public TextView object_location;
        public TextView object_id;
        public TextView object_active;
        public TextView object_createdBy;
        public TextView object_datails;

        public ObjectBoundaryViewHolder(@NonNull View itemView) {
            super(itemView);
            object_alias = itemView.findViewById(R.id.object_alias);
            object_location = itemView.findViewById(R.id.object_location);
            object_datails = itemView.findViewById(R.id.object_datails);
            object_id =itemView.findViewById(R.id.object_id);
            object_active=itemView.findViewById(R.id.object_active);
            object_createdBy=itemView.findViewById(R.id.object_createdBy);
        }
    }
}
