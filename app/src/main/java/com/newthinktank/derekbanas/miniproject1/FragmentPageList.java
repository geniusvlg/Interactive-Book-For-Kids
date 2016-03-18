package com.newthinktank.derekbanas.miniproject1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

/**
 * Created by Huy on 6/28/2015.
 */
public class FragmentPageList extends Fragment {
    Communicator com;
     int bookNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_page_list,container,false);
        String[] page_list={"1", "2","3","4","5","6","7","8","9","10","Quiz Session"};
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,page_list);
        final ListView theListView = (ListView)view.findViewById(R.id.list_view);
        theListView.setAdapter(adapter);
        theListView.setOnItemClickListener(onItemClickListener);
        return view;
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            PageList activiy = (PageList) getActivity();
            if(position == 10){
                Intent goToQuestion = new Intent(getActivity(),Question.class);
                goToQuestion.putExtra("bookNumber",activiy.getbookNumber());
                startActivity(goToQuestion);
            }else {
                com = (Communicator) getActivity();
                com.respond(position, activiy.getbookNumber());
            }
        }
    };
}
