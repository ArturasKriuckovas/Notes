package com.example.art.notes;



public class NotesDB{
    private int _id;
    private String _noteEntry;

    public NotesDB(){
    }
    public NotesDB(String noteEntry){
        this._noteEntry = noteEntry;
    }
    public void set_id(int _id){
        this._id = _id;
    }
    public void set_noteEntry(String _noteEntry){
        this._noteEntry = _noteEntry;
    }
    public int get_id(){
        return _id;
    }
    public String get_noteEntry(){
        return _noteEntry;
    }
}
