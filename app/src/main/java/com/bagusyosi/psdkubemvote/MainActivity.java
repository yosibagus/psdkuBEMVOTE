package com.bagusyosi.psdkubemvote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

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
    }

    private void toVote() {
        startActivity(new Intent(context, VotingActivity.class));
        animasiInOut();
    }
    private void toResult() {
        startActivity(new Intent(context, ResultActivity.class));
        animasiInOut();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        linkToVote.setBackgroundColor(Color.parseColor("#ffeeef"));
        linkToResult.setBackgroundColor(Color.parseColor("#eff4fd"));
    }

    private void animasiInOut() {
        overridePendingTransition(R.anim.skuy, R.anim.skuyk);
    }
}
