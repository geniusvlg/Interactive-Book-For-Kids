package com.newthinktank.derekbanas.miniproject1;

import android.app.Fragment;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.util.Locale;

/**
 * Created by Huy on 6/28/2015.
 */
public class FragmentPageDetail extends Fragment {
    TextView text;
    TextToSpeech ttsobject;
    int result;
    private Locale currentSpokenLang = Locale.US;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           View view = inflater.inflate(R.layout.fragment_page_detail, container, false);
           return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        text=(TextView) getActivity().findViewById(R.id.textView);
    }

    public void getBookIndex(int position, int bookNumber) {
        if(position == 10){
            questionTest(bookNumber);
        }else {

            if (bookNumber == 0) {
                text.setText(PageInfo.ONE[position]);
            } else if (bookNumber == 1) {
                text.setText(PageInfo.TWO[position]);
        }else if (bookNumber == 2) {
                text.setText(PageInfo.THREE[position]);
        }else if(bookNumber ==3){
                text.setText(PageInfo.FOUR[position]);
        }else if(bookNumber ==4){
                text.setText(PageInfo.FIVE[position]);
        }else if(bookNumber ==5){
                text.setText(PageInfo.SIX[position]);
        }else if (bookNumber ==6){
                text.setText(PageInfo.SEVEN[position]);
            }
        }
    }

    private void questionTest(int bookNumber) {
        //Toast.makeText(getActivity(),"" + bookNumber,Toast.LENGTH_SHORT).show();
        Intent goToQuestion = new Intent(getActivity(),Question.class);
        goToQuestion.putExtra("bookNumber",bookNumber);
       startActivity(goToQuestion);
    }

}
