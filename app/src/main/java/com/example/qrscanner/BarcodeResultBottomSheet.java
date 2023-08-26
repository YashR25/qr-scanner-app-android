package com.example.qrscanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.Inflater;

public class BarcodeResultBottomSheet extends BottomSheetDialogFragment {

    private TextView title,desc,url,visit;
    String url1,fetchurl;
    String desc1,title1;
    private ImageView close;
//
//    public BarcodeResultBottomSheet(String url1) {
//        this.url1 = url1;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_barcode_data,container,false);

        title = view.findViewById(R.id.text_view_title);
        desc = view.findViewById(R.id.text_view_desc);
        url = view.findViewById(R.id.text_view_link);
        visit = view.findViewById(R.id.text_view_visit_link);
        close = view.findViewById(R.id.close);

        title.setText(url1);


        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(url1));
                startActivity(intent);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });





        return view;






    }


    public void UpdateURL(String url){
        fetchMetaData(url);

    }

    public void fetchMetaData(String url) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                url1 = url;


//                try {
//                    Document doc = Jsoup.connect(url).get();
//                   desc1 = doc.select("meta[name=description]").get(0).attr("content");
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            title1 = doc.title();
//                            title.setText(title1 + "");
//                            desc.setText(desc1 + "");
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
                }


            });
        }

    }



