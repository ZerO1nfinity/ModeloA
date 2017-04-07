package com.zero.modeloa;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.zero.modeloa.view.ContainerActivity;
import com.zero.modeloa.view.CreateAccountActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.edt_username) TextInputEditText username;
    @BindView(R.id.edt_password) TextInputEditText password;
    @BindView(R.id.img_logo) ImageView img_logo;
    @BindString(R.string.username_card) String STRING_USERNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        username.setText(STRING_USERNAME);
    }

    @OnClick(R.id.img_logo) void goToWeb() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.grupoarcuna.com"));
        startActivity(intent);
    }

    @OnClick(R.id.btn_login) public void Login(View view){
        Intent intent = new Intent(LoginActivity.this, ContainerActivity.class);
        startActivity(intent);
        //finish();
    }

    public void goCreateAccount(View view){
        Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
        startActivity(intent);
        //finish();
    }
}
