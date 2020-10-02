package com.yeghon.myfarmapp.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.snackbar.Snackbar;
import com.yeghon.myfarmapp.R;

/**
 * Created on Friday, 10/2/20
 * By YeghonHaron.
 * Copyright 2020 Yjungle Inc.
 */
public class CommonFunctions {

    public static void contactUs(final Context context) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("\n Contact Us");
        alertDialogBuilder.setMessage(
                context.getResources().getString(R.string.companyname) + " \n\n" +
                        context.getResources().getString(R.string.companyLocation) + " \n\n" +
                        context.getResources().getString(R.string.companyEmail) + " \n\n" +
                        context.getResources().getString(R.string.companyWebsite) + " \n\n" +
                        context.getResources().getString(R.string.contactPhone));
        alertDialogBuilder.setPositiveButton("Ok!",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
        alertDialogBuilder.setNeutralButton("Call Us!",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        makePhoneCall(context, context.getResources().getString(R.string.contactPhone));
                    }
                });
        alertDialogBuilder.setNegativeButton("Visit Website!",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        openBrowser(context, context.getResources().getString(R.string.companyWebsite));
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

    }

    public static void makePhoneCall(Context context, String toPhone) {
        context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", toPhone, null)));
    }

//    public static void shareSocial(Context context, String url){
//        Intent sendIntent = new Intent();
//        sendIntent.setAction(Intent.ACTION_SEND);
//        sendIntent.putExtra(Intent.EXTRA_TEXT, "Get instant access to quick loans. Click <applink>");
//        sendIntent.setType("text/plain");
//        sendIntent.setPackage(url);
//        try {
//            context.startActivity(sendIntent);
//        } catch (Exception e){
//            openBrowser(context, "http://www." + url.split("\\.")[1] + ".com");
//        }
//    }

    public static void openBrowser(Context context, String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        context.startActivity(i);
    }

    public static void showSnack(View v, String message) {
        Snackbar.make(v, "".concat(message), Snackbar.LENGTH_LONG).show();
    }
}