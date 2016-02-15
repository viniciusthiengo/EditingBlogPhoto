package br.com.thiengo.editingblogphoto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.aviary.android.feather.sdk.AviaryIntent;
import com.aviary.android.feather.sdk.internal.headless.utils.MegaPixels;

public class MainActivity extends AppCompatActivity {

    private static final int IMG_CODE_EDIT = 263;
    private ImageView ivImg;
    private EditText etUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImg = (ImageView) findViewById(R.id.iv_img);
        etUri = (EditText) findViewById(R.id.et_uri);

        Intent intent = AviaryIntent.createCdsInitIntent(this);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        etUri.setText("http://www.thiengo.com.br/img/post/facebook/650-366/4hatgipaq97ru4b8fveftph3r5a3303f0862a3beca4f39837355464dd4.png");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == IMG_CODE_EDIT
                && resultCode == RESULT_OK ){

            Uri imgUri = data.getData();
            ivImg.setImageURI( imgUri );
            Log.i("LOG", "--> "+imgUri);
        }
    }

    public void callEditImage(View view ){

        Uri imguri = Uri.parse( etUri.getText().toString() );
        Intent intent = new AviaryIntent.Builder(this)
                .setData( imguri )
                .withOutputSize(MegaPixels.Mp10)
                .withOutputQuality(100)
                .build();

        startActivityForResult( intent, IMG_CODE_EDIT );
    }
}
