package com.example.qrcodesaccner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.android.gms.vision.barcode.BarcodeDetector.Builder;
import com.google.zxing.Result;

import java.io.IOException;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
  ZXingScannerView scannerView;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      scannerView=new ZXingScannerView(this);
      setContentView(scannerView);
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    public void handleResult(Result result) {
        Intent intent=new Intent(MainActivity.this,Detail.class);
        String detail=result.getText();
    intent.putExtra("detail",detail);
    startActivity(intent);
    }
}
