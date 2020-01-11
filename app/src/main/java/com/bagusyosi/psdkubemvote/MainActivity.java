package com.bagusyosi.psdkubemvote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.bagusyosi.psdkubemvote.activity.ProceduresActivity;
import com.bagusyosi.psdkubemvote.activity.ProfileActivity;
import com.bagusyosi.psdkubemvote.activity.ResultActivity;
import com.bagusyosi.psdkubemvote.activity.VotingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.menuVoting)
    LinearLayout linkToVote;
    @BindView(R.id.cardViewVote)
    CardView cardToVote;
    @BindView(R.id.cardViewResult)
    CardView cardToRestult;
    @BindView(R.id.linkToResult)
    LinearLayout linkToResult;
    @BindView(R.id.cardViewProcedures)
    CardView cardToProcedures;
    @BindView(R.id.linkToProcedures)
    LinearLayout linkToProcedures;
    @BindView(R.id.cardViewProfile)
    CardView cardToProfile;
    @BindView(R.id.linkToProfile)
    LinearLayout linkToProfile;


    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ButterKnife.bind(this);
        context = this;

        cardToVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkToVote.setBackgroundColor(Color.parseColor("#ff6263"));
                toVote();
            }
        });

        cardToRestult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkToResult.setBackgroundColor(Color.parseColor("#7FA9F7"));
                toResult();
            }
        });

        cardToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkToProfile.setBackgroundColor(Color.parseColor("#FABE7A"));
                toProfile();
            }
        });

        cardToProcedures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkToProcedures.setBackgroundColor(Color.parseColor("#6EF879"));
                toProcedures();
            }
        });
    }

    private void toVote() {
        startActivity(new Intent(context, VotingActivity.class));
        animasiInOut();
    }
    private void toResult() {
        startActivity(new Intent(context, ResultActivity.class));
        animasiInOut();
    }
    private void toProfile() {
        startActivity(new Intent(context, ProfileActivity.class));
        animasiInOut();
    }
    private void toProcedures() {
        startActivity(new Intent(context, ProceduresActivity.class));
        animasiInOut();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        linkToVote.setBackgroundColor(Color.parseColor("#ffeeef"));
        linkToResult.setBackgroundColor(Color.parseColor("#eff4fd"));
        linkToProfile.setBackgroundColor(Color.parseColor("#FFF7EE"));
        linkToProcedures.setBackgroundColor(Color.parseColor("#edfaee"));
    }

    private void animasiInOut() {
        overridePendingTransition(R.anim.skuy, R.anim.skuyk);
    }
}
