package com.gleme.kotlinrestapi.entity

//import org.springframework.data.annotation.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Note(
        @Id
        @GeneratedValue
        val id: Int = 0,
        val text: String
) {
        //constructor() : this(1, "")
}

