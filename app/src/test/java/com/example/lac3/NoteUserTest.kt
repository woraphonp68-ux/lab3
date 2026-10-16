package com.example.lac3

import org.junit.Test
import org.junit.Assert.*

class NoteUserTest {

    @Test
    fun testNoteSummary() {
        val shortNote = Note(id = "1", title = "Test", content = "Short content")
        assertEquals("Short content", shortNote.getSummary())

        val longContent = "A".repeat(60)
        val longNote = Note(id = "2", title = "Test", content = longContent)
        assertEquals(53, longNote.getSummary().length) // 50 chars + "..."
        assertTrue(longNote.getSummary().endsWith("..."))
    }

    @Test
    fun testUserNoteManagement() {
        val user = User(id = "u1", username = "alice", email = "alice@example.com")
        assertEquals(0, user.getTotalNotesCount())

        val note1 = Note(id = "n1", title = "Kotlin", content = "Learn Kotlin programming")
        val note2 = Note(id = "n2", title = "Android", content = "Build Android apps with Compose")

        user.addNote(note1)
        user.addNote(note2)
        assertEquals(2, user.getTotalNotesCount())

        val searchResults = user.searchNotes("Compose")
        assertEquals(1, searchResults.size)
        assertEquals("Android", searchResults[0].title)

        val removed = user.removeNote("n1")
        assertTrue(removed)
        assertEquals(1, user.getTotalNotesCount())
        assertEquals("n2", user.notes[0].id)
    }
}
