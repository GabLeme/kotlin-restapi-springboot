package com.gleme.kotlinrestapi.repository

import com.gleme.kotlinrestapi.entity.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : JpaRepository<Note, Integer> {
}