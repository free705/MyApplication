package com.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    Switch SwitchAgree;
    RadioGroup rGroup;
    RadioButton rdoBean, rdoKat, rdoPop;
    Button btnESC, btnBack;
    ImageView imgVersion;
    RadioButtonListener RBL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        SwitchAgree = (Switch) findViewById(R.id.SwitchAgree);
        rGroup = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoBean = (RadioButton) findViewById(R.id.RdoBean);
        rdoKat = (RadioButton) findViewById(R.id.RdoKat);
        rdoPop = (RadioButton) findViewById(R.id.RdoPop);

        btnESC = (Button) findViewById(R.id.BtnESC);
        btnBack = (Button) findViewById(R.id.BtnBack);
       imgVersion = (ImageView) findViewById(R.id.ImgVersion);

        RBL = new RadioButtonListener();

        SwitchAgree.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rGroup.setVisibility(View.VISIBLE);
                    rdoBean.setVisibility(View.VISIBLE);
                    rdoKat.setVisibility(View.VISIBLE);
                    rdoPop.setVisibility(View.VISIBLE);
                    btnESC.setVisibility(View.VISIBLE);
                    btnBack.setVisibility(View.VISIBLE);
                    imgVersion.setVisibility(View.VISIBLE);
                } else {
                    rGroup.setVisibility(View.INVISIBLE);
                    rdoBean.setVisibility(View.VISIBLE);
                    rdoKat.setVisibility(View.VISIBLE);
                    rdoPop.setVisibility(View.VISIBLE);
                    btnESC.setVisibility(View.INVISIBLE);
                    btnBack.setVisibility(View.INVISIBLE);
                    imgVersion.setVisibility(View.INVISIBLE);
                }
            }
        });
        rdoBean.setOnClickListener(RBL);
        rdoKat.setOnClickListener(RBL);
        rdoPop.setOnClickListener(RBL);
        btnESC.setOnClickListener(RBL);
        btnBack.setOnClickListener(RBL);
    }
    class RadioButtonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.RdoBean:
                    imgVersion.setImageResource(R.drawable.bean);
                    break;
                case R.id.RdoKat:
                    imgVersion.setImageResource(R.drawable.kat);
                    break;
                case R.id.RdoPop:
                    imgVersion.setImageResource(R.drawable.pop);
                    break;
                case R.id.BtnESC:
                    System.exit(0);
                    break;
                case R.id.BtnBack:
                    SwitchAgree.setChecked(false);
                    break;
            }
        }
    }
}

