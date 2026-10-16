package com.example.lac3

import java.util.Date


data class Note(
    val id: String,
    var title: String,
    var content: String,
    val createdDate: Date = Date()
) {

    fun getSummary(): String {
        return if (content.length <= 50) {
            content
        } else {
            content.take(50) + "..."
        }
    }
}
