package com.newthinktank.derekbanas.miniproject1;

import android.app.*;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Huy on 6/28/2015.
 */
public class PageList extends Activity implements Communicator {
    View detailPanel;
    int position;
    TextToSpeech ttsobject;
    int result;
    private Locale currentSpokenLang = Locale.US;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_list);
        if(checkOrientation() == Configuration.ORIENTATION_PORTRAIT)
            hideDetailPanel();
        ttsobject = new TextToSpeech(PageList.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    //The syntax to set language
                    result =   ttsobject.setLanguage(currentSpokenLang);
                }else {
                    Toast.makeText(getBaseContext(),"Feature Not Supported",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public int getbookNumber(){
      Intent calledActivity = getIntent();
        return calledActivity.getExtras().getInt("bookNumber");
    }

    private void hideDetailPanel() {
        detailPanel = (View) findViewById(R.id.page_detail);
        detailPanel.setVisibility(View.GONE);
    }

    private int checkOrientation() {
        int screenOrientation;
        return screenOrientation = getResources().getConfiguration().orientation;
    }


    @Override
    public void respond(int page, int vol) {
        if(checkOrientation() == Configuration.ORIENTATION_PORTRAIT)
            detailPanel.setVisibility(View.VISIBLE);
            FragmentManager manager = getFragmentManager();
        FragmentPageDetail f2 = (FragmentPageDetail)manager.findFragmentById(R.id.page_detail);
        f2.getBookIndex(page,vol);
        position = page;
    }

    @Override
    public void onBackPressed() {
        // Write your code here
        if (detailPanel.getVisibility() == View.VISIBLE) {
            detailPanel.setVisibility(View.GONE);
        }else{
            Intent goToBookList = new Intent(PageList.this,BookList.class);
            startActivity(goToBookList);
            startActivity(goToBookList);
        }
    }

    public void doSomeThing(View view){
       Intent calledActivity = getIntent();
        int book = calledActivity.getExtras().getInt("bookNumber");
        if(book == 0) {
        ttsobject.speak(PageInfo.ONE[position],TextToSpeech.QUEUE_FLUSH,null);
        }else if(book == 1){
            ttsobject.speak(PageInfo.TWO[position],TextToSpeech.QUEUE_FLUSH,null);
        }else if(book == 2){
            ttsobject.speak(PageInfo.THREE[position],TextToSpeech.QUEUE_FLUSH,null);
        }else if(book == 3){
            ttsobject.speak(PageInfo.FOUR[position],TextToSpeech.QUEUE_FLUSH,null);
        }else if(book == 4){
            ttsobject.speak(PageInfo.FIVE[position],TextToSpeech.QUEUE_FLUSH,null);
        }else if(book == 5){
            ttsobject.speak(PageInfo.SIX[position],TextToSpeech.QUEUE_FLUSH,null);
        }else if(book == 6){
            ttsobject.speak(PageInfo.SEVEN[position],TextToSpeech.QUEUE_FLUSH,null);
        }

    }
}
