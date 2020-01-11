package com.bagusyosi.psdkubemvote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bagusyosi.psdkubemvote.R;
import com.bagusyosi.psdkubemvote.model.ModelCapres;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import static com.bagusyosi.psdkubemvote.api.RestClient.IMG_URL;

public class AdapterCapres extends RecyclerView.Adapter<AdapterCapres.CapresHolder> {

    Context mContext;
    List<ModelCapres> modelCapresList;
    private onCapresListerner onCapresClickListener;

    public AdapterCapres(Context mContext, List<ModelCapres> modelCapresList) {
        this.mContext = mContext;
        this.modelCapresList = modelCapresList;
    }

    @NonNull
    @Override
    public CapresHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_capres, parent, false);
        return new CapresHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CapresHolder holder, int position) {
        final ModelCapres allCapresOnVoting = modelCapresList.get(position);
        Glide.with(mContext)
                .load(IMG_URL + allCapresOnVoting.getFotoCalon())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgCalon);
        holder.nomerUrutCalon.setText(String.valueOf(allCapresOnVoting.getNomerUrutCalon()));
        holder.sloganCalon.setText(allCapresOnVoting.getSloganCalon());
        holder.namaCapres.setText(allCapresOnVoting.getNamaCapres());
        holder.namaCawapres.setText(allCapresOnVoting.getNamaCawapres());

        final int i= position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCapresClickListener != null) {
                    onCapresClickListener.onCapresClick(allCapresOnVoting.getNomerUrutCalon(), i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelCapresList.size();
    }

    public interface onCapresListerner {
        void onCapresClick(int capresId, int position);
    }


    public class CapresHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgCalon)
        ImageView imgCalon;
        @BindView(R.id.nomerUrutCalon)
        TextView nomerUrutCalon;
        @BindView(R.id.sloganCalon)
        TextView sloganCalon;
        @BindView(R.id.namaCapres)
        TextView namaCapres;
        @BindView(R.id.namaCawapres)
        TextView namaCawapres;

        public CapresHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
