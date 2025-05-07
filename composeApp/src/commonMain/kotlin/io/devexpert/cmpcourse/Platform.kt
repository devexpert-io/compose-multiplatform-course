package io.devexpert.cmpcourse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform