package com.bagusyosi.psdkubemvote.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bagusyosi.psdkubemvote.R;
import com.bagusyosi.psdkubemvote.utils.Constant;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfirmVotingActivity extends AppCompatActivity {
    @BindView(R.id.namaCapres_confirm)
    TextView namaCapresConfirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_vote);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        Intent in = getIntent();
        String tmp_namaCapres = in.getStringExtra(Constant.KEY_NAMACAPRES);

        //set data textview
        namaCapresConfirm.setText(tmp_namaCapres);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideDown(ConfirmVotingActivity.this);
    }
}
