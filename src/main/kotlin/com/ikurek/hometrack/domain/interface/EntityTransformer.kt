package com.ikurek.hometrack.domain.`interface`

interface EntityTransformer<from, to> {

    fun toDTO(from: from): to

    fun fromDTO(to: to): from
}