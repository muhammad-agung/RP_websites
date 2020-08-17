package sg.edu.rp.c346.id18004536.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class BrowseActivity extends AppCompatActivity {

    WebView wvMyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);


        wvMyPage = findViewById(R.id.webViewMyPage);

        wvMyPage.setWebViewClient(new WebViewClient());
        wvMyPage.getSettings().setJavaScriptEnabled(true);
        wvMyPage.getSettings().setAllowFileAccess(false);
        wvMyPage.getSettings().setBuiltInZoomControls(true);

        Intent intentReceived = getIntent();
        String value = intentReceived.getStringExtra("Value");
        wvMyPage.loadUrl(value);
    }
}
