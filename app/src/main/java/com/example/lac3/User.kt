package com.example.lac3


data class User(
    val id: String,
    var username: String,
    var email: String,
    val notes: MutableList<Note> = mutableListOf()
) {

    fun addNote(note: Note) {
        notes.add(note)
    }


    fun removeNote(noteId: String): Boolean {
        return notes.removeIf { it.id == noteId }
    }


    fun getTotalNotesCount(): Int {
        return notes.size
    }


    fun searchNotes(keyword: String): List<Note> {
        return notes.filter { 
            it.title.contains(keyword, ignoreCase = true) || 
            it.content.contains(keyword, ignoreCase = true) 
        }
    }
}
