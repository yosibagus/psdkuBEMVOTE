package com.bagusyosi.psdkubemvote.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bagusyosi.psdkubemvote.R;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class VotingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        getSupportActionBar().hide();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.skuy, R.anim.skuyk);
    }
}
