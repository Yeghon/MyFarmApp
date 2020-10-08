package com.yeghon.myfarmapp.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.yeghon.myfarmapp.R;

import static com.yeghon.myfarmapp.utils.CommonFunctions.showSnack;

/**
 * Created on Friday, 10/2/20
 * By YeghonHaron.
 * Copyright 2020 Yjungle Inc.
 */
public class CustomDialog {

    public static void show(final View view, final Context context, final String dialogType) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext(), R.style.CustomAlertDialog);
//        View rootView = ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);

        ViewGroup viewGroup = (ViewGroup) view;
        View dialogView = null;
        switch (dialogType) {
            case "pinReset":
                dialogView = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.reset_pin, viewGroup, false);
                break;
            case "signUp":
                dialogView = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.sign_up, viewGroup, false);
                break;
            default:
                break;
        }
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(true);
//        if (!context.isFinishing()) {
        alertDialog.show();

        /**
         * Collect user details from UI component
         */
        switch (dialogType) {
            case "pinReset":
                final EditText passReset = dialogView.findViewById(R.id.reset_pass_value);
                final Button passResetButton = dialogView.findViewById(R.id.resetPassword);
//                final AdView pinad = dialogView.findViewById(R.id.adView);
//                loadAd(context, pinad);
                passResetButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Check for empty or null field values and process pin reset
                        // default to signed in user under preferences for future iterations
                        if (passReset.getText().toString().equalsIgnoreCase(""))
                            showSnack(view, "Email or phone can never be empty");
                        else {
                            // reset customer Pin
                        }
                    }
                });
                break;
            case "signUp":
                final EditText userName = dialogView.findViewById(R.id.sign_up_username);
                final EditText userPhone = dialogView.findViewById(R.id.sign_up_user_phone);
                final EditText userPass = dialogView.findViewById(R.id.sign_up_user_pass);
                final EditText userConfirmPass = dialogView.findViewById(R.id.sign_up_user_confirm_pass);
                final Button userSignUp = dialogView.findViewById(R.id.new_sign_up);
//                final AdView userad = dialogView.findViewById(R.id.adView1);
//                loadAd(context, userad);

                userSignUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (userName.getText().toString().equalsIgnoreCase(""))
                            showSnack(view, "Username can never be empty!");
                        else if (userPhone.getText().toString().equalsIgnoreCase(""))
                            showSnack(view, "Enter your phone number!");
                        else if (userPass.getText().toString().equalsIgnoreCase(""))
                            showSnack(view, "Password can never be empty!");
                        else if (userConfirmPass.getText().toString().equalsIgnoreCase(""))
                            showSnack(view, "Confirm password can never be empty!");
                        else if (!userConfirmPass.getText().toString().equalsIgnoreCase(userPass.getText().toString()))
                            showSnack(view, "Password and confirm password need to match!");
                        else if (!validPass(userPass.getText().toString(), userConfirmPass.getText().toString()))
                            showSnack(view, "Invalid password!");
                        else {
                            // sign up new user
                        }
                    }

                    private boolean validPass(String toString, String toString1) {
                        // validate password as valid within set protocols
                        return true;
                    }
                });

                break;
            default:
                break;
        }
    }

    /*private static void loadAd(Context context, AdView userad) {
        MobileAds.initialize(context, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        userad.loadAd(adRequest);
    }*/
}