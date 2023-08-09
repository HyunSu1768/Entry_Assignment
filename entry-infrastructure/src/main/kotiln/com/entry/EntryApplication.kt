package com.entry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class EntryApplication

fun main(args: Array<String>){
    runApplication<EntryApplication>(*args)
}