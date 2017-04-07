package com.zero.modeloa;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.zero.modeloa.view.ContainerActivity;
import com.zero.modeloa.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView img_login = (ImageView) findViewById(R.id.img_logo);
        img_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.grupoarcuna.com"));
                startActivity(intent);
            }
        });

    }

    public void Login(View view){
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
