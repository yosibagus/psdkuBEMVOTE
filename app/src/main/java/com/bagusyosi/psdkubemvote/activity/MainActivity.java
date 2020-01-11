package com.bagusyosi.psdkubemvote.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bagusyosi.psdkubemvote.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.namaMenu) TextView namaMenu;
    @BindView(R.id.namaMenuProfile) TextView namaMenuProfile;
    @BindView(R.id.namaMenuResult) TextView namaMenuResult;
    @BindView(R.id.namaMenuProsedure) TextView namaMenuProcedure;
    @BindView(R.id.menuVoting) LinearLayout linkToVote;
    @BindView(R.id.cardViewVote) CardView cardToVote;
    @BindView(R.id.cardViewResult) CardView cardToRestult;
    @BindView(R.id.linkToResult) LinearLayout linkToResult;
    @BindView(R.id.cardViewProcedures) CardView cardToProcedures;
    @BindView(R.id.linkToProcedures) LinearLayout linkToProcedures;
    @BindView(R.id.cardViewProfile) CardView cardToProfile;
    @BindView(R.id.linkToProfile) LinearLayout linkToProfile;


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
                namaMenu.setTextColor(Color.WHITE);
                toVote();
            }
        });

        cardToRestult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkToResult.setBackgroundColor(Color.parseColor("#7FA9F7"));
                namaMenuResult.setTextColor(Color.WHITE);
                toResult();
            }
        });

        cardToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkToProfile.setBackgroundColor(Color.parseColor("#FABE7A"));
                namaMenuProfile.setTextColor(Color.WHITE);
                toProfile();
            }
        });

        cardToProcedures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkToProcedures.setBackgroundColor(Color.parseColor("#77E280"));
                namaMenuProcedure.setTextColor(Color.WHITE);
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
        namaMenu.setTextColor(Color.BLACK);
        linkToResult.setBackgroundColor(Color.parseColor("#eff4fd"));
        namaMenuResult.setTextColor(Color.BLACK);
        linkToProfile.setBackgroundColor(Color.parseColor("#FFF7EE"));
        namaMenuProfile.setTextColor(Color.BLACK);
        linkToProcedures.setBackgroundColor(Color.parseColor("#edfaee"));
        namaMenuProcedure.setTextColor(Color.BLACK);
    }

    private void animasiInOut() {
        overridePendingTransition(R.anim.skuy, R.anim.skuyk);
    }
}
