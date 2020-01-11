package com.bagusyosi.psdkubemvote.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bagusyosi.psdkubemvote.R;
import com.bagusyosi.psdkubemvote.adapter.AdapterCapres;
import com.bagusyosi.psdkubemvote.api.BaseApiService;
import com.bagusyosi.psdkubemvote.api.RestClient;
import com.bagusyosi.psdkubemvote.model.ModelCapres;
import com.bagusyosi.psdkubemvote.response.ResponseCapres;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VotingActivity extends AppCompatActivity {

    ProgressDialog loading;
    Context mContext;
    List<ModelCapres> modelCapresList;
    AdapterCapres adapter;
    BaseApiService mApiService;

    @BindView(R.id.RecycleViewItemVote)
    RecyclerView rvItemVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        mContext = this;
        mApiService = RestClient.getApiService();

        getAllItemVoting();

    }

    private void getAllItemVoting() {
        loading = ProgressDialog.show(mContext, null, "Sedang Mengambil Data", true, false);

        final Activity that = this;
        rvItemVote.setVisibility(View.GONE);
        modelCapresList = new ArrayList<>();
        adapter = new AdapterCapres(VotingActivity.this, modelCapresList);

        rvItemVote.setLayoutManager(new LinearLayoutManager(this));
        rvItemVote.setAdapter(adapter);

        Call<ResponseCapres> rest = mApiService.getAllCapresOnVoting();
        rest.enqueue(new Callback<ResponseCapres>() {
            @Override
            public void onResponse(Call<ResponseCapres> call, Response<ResponseCapres> response) {
                if (response.isSuccessful()) {
                    rvItemVote.setVisibility(View.VISIBLE);
                    loading.dismiss();
                    modelCapresList.clear();
                    modelCapresList.addAll(response.body().getAllCapresOnVoting());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseCapres> call, Throwable t) {
                loading.dismiss();
                Log.d("error", t.getMessage());
                Toast.makeText(that, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.skuy, R.anim.skuyk);
    }
}
