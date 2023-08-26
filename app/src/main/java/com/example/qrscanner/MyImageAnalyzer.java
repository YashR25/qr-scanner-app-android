package com.example.qrscanner;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.common.InputImage;

import java.util.List;

//public class MyImageAnalyzer implements ImageAnalysis.Analyzer {
//
//    private FragmentManager fragmentManager;
//    private BarcodeResultBottomSheet bottomSheet;
//
//    public MyImageAnalyzer(FragmentManager fragmentManager) {
//        this.fragmentManager = fragmentManager;
////        bottomSheet = new BarcodeResultBottomSheet();
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    @Override
//    public void analyze(@NonNull ImageProxy image) {
//        scanBarcode(image);
//
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    @SuppressLint("UnsafeExperimentalUsageError")
//    private void scanBarcode(ImageProxy image) {
//
//         Image image1 = image.getImage();
//        assert image1 != null;
//        InputImage inputImage = InputImage.fromMediaImage(image1,image.getImageInfo().getRotationDegrees());
//        BarcodeScannerOptions options = new BarcodeScannerOptions.Builder()
//                .setBarcodeFormats(Barcode.FORMAT_ALL_FORMATS)
//                .build();
//        BarcodeScanner scanner = BarcodeScanning.getClient(options);
//        Task<List<Barcode>> result = scanner.process(inputImage)
//                .addOnSuccessListener(new OnSuccessListener<List<Barcode>>() {
//                    @Override
//                    public void onSuccess(List<Barcode> barcodes) {
//                        readerBarcodeData(barcodes);
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        // Task failed with an exception
//                        // ...
//                    }
//                })
//                .addOnCompleteListener(new OnCompleteListener<List<Barcode>>() {
//                    @Override
//                    public void onComplete(@NonNull Task<List<Barcode>> task) {
//                        image.close();
//                    }
//                });
//
//
//
//    }
//
//
//    private void readerBarcodeData(List<Barcode> barcodes) {
//        for (Barcode barcode: barcodes) {
//            Rect bounds = barcode.getBoundingBox();
//            Point[] corners = barcode.getCornerPoints();
//
//            String rawValue = barcode.getRawValue();
//
//            bottomSheet = new BarcodeResultBottomSheet(rawValue);
//
//            int valueType = barcode.getValueType();
//
//            Log.v("Testing:","Barcode detected: " + rawValue);
//            // See API reference for complete list of supported types
//            switch (valueType) {
//                case Barcode.TYPE_WIFI:
//                    String ssid = barcode.getWifi().getSsid();
//                    String password = barcode.getWifi().getPassword();
//                    int type = barcode.getWifi().getEncryptionType();
//                    Log.e("insert","ok");
//                    break;
//                case Barcode.TYPE_URL:
//                    if (!bottomSheet.isAdded()){
//                        bottomSheet.show(fragmentManager,"");
//                    }
//                    String title = barcode.getUrl().getTitle();
//                    String url = barcode.getUrl().getUrl();
//                    Log.v("insert",url + "");
//                    break;
//            }
//        }
//    }
//}
