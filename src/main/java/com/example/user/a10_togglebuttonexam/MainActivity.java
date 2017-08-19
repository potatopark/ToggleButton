package com.example.user.a10_togglebuttonexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    TextView textView1, textView2;
    ToggleButton toggleButton1, toggleButton2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        button = (Button) findViewById(R.id.button);

        toggleButton2.setChecked(true);

        toggleButton1.setOnCheckedChangeListener(this);
        toggleButton2.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.toggleButton1:
                ToggleButton tb = (ToggleButton) buttonView;
                if(isChecked) {
                    textView1.setText(tb.getTextOn());
                }else{
                    textView1.setText(tb.getTextOff());
                }
                break;

            case R.id.toggleButton2:
                if(isChecked) {
                    textView2.setText("좋아요 눌러짐");
                }else {
                    textView2.setText("좋아요 취소됨");
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        boolean checked1 = toggleButton1.isChecked();
        boolean checked2 = toggleButton2.isChecked();

        String msg1 = null, msg2 = null;

        if(checked1) {
            msg1 = "설정됨";
        }else{
            msg1 = "설정해제";
        }
        if(checked2){
            msg2 = "설정됨";
        }else{
            msg2 = "설정해제";
        }
        Toast.makeText(this,"기본버튼: "+msg1 +" / 이미지버튼: "+ msg2,
                Toast.LENGTH_SHORT).show();
    }
}
