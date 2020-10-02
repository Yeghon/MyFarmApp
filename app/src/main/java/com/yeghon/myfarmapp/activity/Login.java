package com.yeghon.myfarmapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yeghon.myfarmapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.yeghon.myfarmapp.utils.CommonFunctions.*;
import static com.yeghon.myfarmapp.utils.CustomDialog.show;

/**
 * Created on Friday, 10/2/20
 * By YeghonHaron.
 * Copyright 2020 Yjungle Inc.
 */
public class Login  extends AppCompatActivity {
    private CircleImageView webHome;
    private TextView pinReset, signUp, contact, terms, webHome1;
    private Button next;
    private EditText phone, pass;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        context = Login.this;

        /**
         * Assign the different UI elements listeners
         */
        webHome = findViewById(R.id.appicon);
        webHome1 = findViewById(R.id.company_name);
        signUp = findViewById(R.id.new_user);
        contact = findViewById(R.id.contact);
        terms = findViewById(R.id.terms);
        pinReset = findViewById(R.id.reset);
        next = findViewById(R.id.proceed);

        /**
         * Capture user entered username and password
         */
        phone = findViewById(R.id.phone);
        pass = findViewById(R.id.pin);

        /**
         * Assign listeners to UI elements
         */

        webHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrowser(context, context.getResources().getString(R.string.companyWebsite));
            }
        });
        webHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrowser(context, context.getResources().getString(R.string.companyWebsite));
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(findViewById(android.R.id.content), context, "signUp");
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactUs(context);
            }
        });
        pinReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(findViewById(android.R.id.content), context, "pinReset");
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display terms and conditions for using app
                openBrowser(context, context.getResources().getString(R.string.companyWebsite));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform login operations
            }
        });


    }
}