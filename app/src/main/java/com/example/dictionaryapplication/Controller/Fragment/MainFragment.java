package com.example.dictionaryapplication.Controller.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionaryapplication.Controller.Model.Word;
import com.example.dictionaryapplication.Repository.WordRepository;
import com.example.dictionaryapplication.R;

import java.util.List;

public class MainFragment extends Fragment {

    private SearchView mSearchView;
    private Word mWord;
    private RecyclerView mRecyclerView;
    private WordRepository mWordRepository;
    private WordAdapter mWordAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        findView(view);
        setListeners();

        return view;
    }

    private void findView(View view){
        mSearchView = view.findViewById(R.id.searchView);
        mRecyclerView = view.findViewById(R.id.recyclerView);
    }

    private void setListeners(){
        mSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "This is search", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUi(){
        List<Word> wordLists = mWordRepository.getWords();

        if (mWordAdapter == null) {
            mWordAdapter = new WordAdapter(wordLists);
            mRecyclerView.setAdapter(mWordAdapter);
        } else {
            mWordAdapter.setWords(wordLists);
            mWordAdapter.notifyDataSetChanged();
        }
    }

    private class WordHolder extends RecyclerView.ViewHolder{

        private Word mWord;
        private TextView mTextViewWord;
        private TextView mTextViewDefinition;

        public WordHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewWord = itemView.findViewById(R.id.row_list_word);
            mTextViewDefinition = itemView.findViewById(R.id.row_list_definition);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //todo
                }
            });
        }

        public void bindWord(Word word) {
            mWord = word;
            mTextViewWord.setText(word.getWord());
            mTextViewDefinition.setText(word.getDefinition());
        }
    }

    private class WordAdapter extends RecyclerView.Adapter<WordHolder>{

        private List<Word> mWordList;

        public List<Word> getWords() {
            return mWordList;
        }

        public void setWords(List<Word> words) {
            mWordList = words;
        }

        public WordAdapter(List<Word> words) {
            mWordList = words;
        }

        @NonNull
        @Override
        public WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.word_row_list, parent, false);
            WordHolder wordHolder = new WordHolder(view);
            return wordHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull WordHolder holder, int position) {
            Word word = mWordList.get(position);
            holder.bindWord(word);
        }

        @Override
        public int getItemCount() {
            return mWordList.size();
        }
    }
}