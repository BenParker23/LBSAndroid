package com.lbs.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.AsyncTask;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lbs.R;
import com.lbs.model.Env;
import com.lbs.model.MProduct;
import com.lbs.model.MUser;
import com.lbs.webservice.ListedProductRequest;

import java.util.List;

public class ManageProductActivity extends AppCompatActivity implements View.OnClickListener {
    private List<MProduct> listedProds;
    private CoordinatorLayout coorLay;
    private int marginCounter = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product);
        coorLay = findViewById(R.id.coorLayManageProd);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getListedProducts();
        populateRowsWithProds();
    }


    private void populateRowsWithProds(){
        for (MProduct prod : listedProds){
            Log.d("ProductID", String.valueOf(prod.getM_Product_ID()));
            ImageView closeImg = new ImageView(this.getApplicationContext());
            closeImg.setImageResource(R.drawable.closeicon);
            closeImg.setId(prod.getM_Product_ID() * 3);
            closeImg.setLayoutParams(createParams(50, 50, 10));
            closeImg.setOnClickListener(this);
            coorLay.addView(closeImg);
            Button button = new Button(this.getApplicationContext());
            button.setText("Edit");
            button.setId(prod.getM_Product_ID());
            button.setLayoutParams(createParams(100, 60,310));
            button.setOnClickListener(this);
            TextView listedProd = new TextView(this.getApplicationContext());
            listedProd.setText(" " + prod.getName());
            listedProd.setBackground(createBorder());
            listedProd.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f);
            listedProd.setLayoutParams(createParams(250, 50, 60));
            coorLay.addView(listedProd);
            coorLay.addView(button);
            marginCounter = marginCounter + getDPFromPixels(getResources(), 60);
        }
    }


    private void refresh(){
        coorLay.removeAllViews();
        marginCounter = 30;
        populateRowsWithProds();
    }


    private ShapeDrawable createBorder(){
        ShapeDrawable sd = new ShapeDrawable();
        sd.setShape(new RectShape());
        sd.getPaint().setColor(Color.BLACK);
        sd.getPaint().setStrokeWidth(5f);
        sd.getPaint().setStyle(Paint.Style.STROKE);
        return sd;
    }


    private void getListedProducts(){
        MUser user = (MUser) Env.getInstance().getProperty("LoggedInUser");
        ListedProductRequest lpr = new ListedProductRequest();
        lpr.execute(user);

        /** Horrible disgusting hack **/
        while (lpr.getStatus().equals(AsyncTask.Status.RUNNING) && lpr.isComplete == false){}
        listedProds = lpr.getProducts();
    }


    /** Create MarginLayoutParams for descending textviews **/
    private ViewGroup.MarginLayoutParams createParams(int width, int height, int left){
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(
                getDPFromPixels(getResources(), width),
                getDPFromPixels(getResources(), height)
        );
        params.topMargin = marginCounter;
        if (left >  0)
            params.leftMargin = getDPFromPixels(getResources(), left);
        return params;
    }

    
    public static int getDPFromPixels(Resources r, int px){
        int pix = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, r.getDisplayMetrics());
        return pix;
    }


    @Override
    public void onClick(final View view) {
        for (final MProduct prod : listedProds){
            /** Edit button **/
            if (view.getId() == prod.getM_Product_ID()){
                new AlertDialog.Builder(this)
                        .setTitle("Remove Listed Product")
                        .setMessage("Are you sure you want to remove this product from listed products?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("Confirm Removal", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                listedProds.remove(prod);
                                refresh();
                                Toast.makeText(ManageProductActivity.this, "Product Removed", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, null).show();
            }
            /** Image ID **/
            else if ( (view.getId() == prod.getM_Product_ID() * 3)){

            }
        }
    }
}
