package com.ikem.data.mappers

interface BaseMapper<E, D> {
    fun transform(type: E): D
}