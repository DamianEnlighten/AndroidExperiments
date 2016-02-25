package com.example.dstrong.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    static final int PROVIDE_INFO_REQUEST_CODE = 1000;
    static final int TAKE_PICTURE_REQUEST_CODE = 1010;

    //<editor-fold desc="Getters for view fields">
    public TextView getClassNameTextView(){
        if (mClassNameTextView == null)
        {
            mClassNameTextView = (TextView) findViewById(R.id.classNameTextView);
        }
        return mClassNameTextView;
    }

    public TextView getNameTextView(){
        if (mNameTextView == null)
        {
            mNameTextView = (TextView) findViewById(R.id.nameTextView);
        }
        return mNameTextView;
    }

    public TextView getEmailTextView(){
        if (mEmailTextView == null)
        {
            mEmailTextView = (TextView) findViewById(R.id.emailTextView);
        }
        return mEmailTextView;
    }
    //</editor-fold>

    //<editor-fold desc="Private view fields">
    TextView mClassNameTextView;
    TextView mNameTextView;
    TextView mEmailTextView;
    //</editor-fold>

    Uri mPhotoPathUri;
    String mPhotoPathName;
    String toastText = "User Canceled";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        setupViews();
    }

    private void setupViews() {
        Button moreInformationButton = (Button) findViewById(R.id.provideInfoButton);
        moreInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity3.this.handleMoreInformationButton((Button) view);
            }
        });
    }

    private void handleMoreInformationButton(Button view) {
        Intent intent = new Intent(this, Provide_Info.class);
        startActivityForResult(intent, PROVIDE_INFO_REQUEST_CODE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity3, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled =false;
        int id = item.getItemId();
        switch(id){
            case R.id.action_toast:
                onClickMenuToast(item);
                handled=true;
                break;
            case R.id.action_close:
                onClickMenuClose(item);
                handled=true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
                break;
        }
        return handled;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        super.onActivityResult(requestCode, resultCode, result);

        switch (requestCode) {
            case PROVIDE_INFO_REQUEST_CODE:
                handleProvideInfoResult(resultCode,result);
                break;
        }
    }

    private void handleProvideInfoResult(int resultCode, Intent result) {
        if (resultCode == RESULT_OK) {
            String className = result.getStringExtra(Provide_Info.CLASS_NAME_EXTRA);
            String name = result.getStringExtra(Provide_Info.PERSON_NAME_EXTRA);
            String email = result.getStringExtra(Provide_Info.PERSON_EMAIL_EXTRA);

            getClassNameTextView().setText(className);
            getNameTextView().setText(name);
            getEmailTextView().setText(email);
        }
        else{
            Toast.makeText(this, toastText,Toast.LENGTH_LONG).show();
        }
    }

    private void onClickMenuToast(MenuItem item) {
        Toast toast = Toast.makeText(this,R.string.action_toast_display,Toast.LENGTH_LONG);
        toast.show();
    }

    private void onClickMenuClose(MenuItem item) {
        finish();
    }


}
