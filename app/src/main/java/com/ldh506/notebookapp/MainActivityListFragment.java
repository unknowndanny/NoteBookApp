package com.ldh506.notebookapp;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


        /*String[] values = new String[]{"Android","iPhone","WindowsMobile",
                "BlackBerry", "WebOS", "Ubuntu", "Windows7", "Mac OS X",
                "Linux", "OS/2"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);*/

        notes = new ArrayList<Note>();
        notes.add(new Note("This is the new note title!", "This is the body of our note!",
                Note.Category.PERSONAL));

        notes.add(new Note("This is the new note title!", "This is the body of our note!", Note.Category.FINANCE));
        notes.add(new Note("This another title", "This body is amazing", Note.Category.QUOTE));
        notes.add(new Note("This... just this", "super secret message", Note.Category.TECHNICAL));
        notes.add(new Note("Title!", "Message!", Note.Category.PERSONAL));
        notes.add(new Note("not even close", "to what anbything lol", Note.Category.QUOTE));
        notes.add(new Note("trolololol", "vampires!", Note.Category.FINANCE));
        notes.add(new Note("the most awesome title ever incorporated", "the most longest of the text note messages in the notes ever", Note.Category.TECHNICAL));

        notes.add(new Note("This is the new note title!", "This is the body of our note!", Note.Category.FINANCE));
        notes.add(new Note("This another title", "This body is amazing", Note.Category.QUOTE));
        notes.add(new Note("This... just this", "super secret message", Note.Category.TECHNICAL));
        notes.add(new Note("Title!", "Message!", Note.Category.PERSONAL));
        notes.add(new Note("not even close", "to what anbything lol", Note.Category.QUOTE));
        notes.add(new Note("trolololol", "vampires!", Note.Category.FINANCE));
        notes.add(new Note("the most awesome title ever incorporated", "the most longest of the text note messages in the notes ever", Note.Category.TECHNICAL));

        
        noteAdapter = new NoteAdapter(getActivity(), notes);

        setListAdapter(noteAdapter);

        // in case the lines between elements do not show up
        // getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.black));
        // getListView().setDividerHeight(1);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        launchNoteDetailActivity(position);
    }

    private void launchNoteDetailActivity(int position){

        // Grab note info associated with clicked note
        Note note = (Note) getListAdapter().getItem(position);

        // Create new intent that launches our note detail activity
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);

        // Pass along Note info to note detail activity
        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA, note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA, note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA, note.getNoteId());

        startActivity(intent);
    }


}
