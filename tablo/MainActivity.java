package com.example.tablo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int RussiaPoint = 0;
    int SSSRPoint = 0;
    TextView counterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt("Russia", RussiaPoint);
        outstate.putInt("SSSR", SSSRPoint);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("Russia") && savedInstanceState.containsKey("SSSR")) {
            RussiaPoint = savedInstanceState.getInt("Russia");
            SSSRPoint = savedInstanceState.getInt("SSSR");
        }
    }

    private void resetUI() {
        ((TextView) findViewById(R.id.Russia)).setText("" + RussiaPoint);
        ((TextView) findViewById(R.id.SSSR)).setText("" + SSSRPoint);

    }

    public void ClickRussia(View view) {
        RussiaPoint++;
        counterView = (TextView)findViewById(R.id.Russia);
        counterView.setText(""+RussiaPoint);
        if (RussiaPoint > 99){
            counterView.setTextSize(56);}
    }

    public void ClickSSSR(View view) {
        SSSRPoint++;
        counterView = (TextView)findViewById(R.id.SSSR);
        counterView.setText(""+SSSRPoint);
        if (SSSRPoint > 99){
            counterView.setTextSize(56); }
    }

    public void ClickResrt(View view) {
        counterView = (TextView)findViewById(R.id.Russia);
        if (RussiaPoint > 99){
            counterView.setTextSize(72);}
        RussiaPoint=0;
        counterView.setText(""+RussiaPoint);
        counterView = (TextView)findViewById(R.id.SSSR);
        if (SSSRPoint > 99){
            counterView.setTextSize(72);}
        SSSRPoint=0;
        counterView.setText(""+SSSRPoint);
    }
}