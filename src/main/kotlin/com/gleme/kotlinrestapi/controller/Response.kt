package com.gleme.kotlinrestapi.controller

class Response<T : Any> {

    var errors: MutableList<String?> = mutableListOf()

    var data : Any = Any()
        set(value) { field = value }
}