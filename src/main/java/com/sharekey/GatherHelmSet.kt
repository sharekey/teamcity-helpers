package com.sharekey

import jetbrains.buildServer.configs.kotlin.v2019_2.Parameter

fun GatherHelmSet(prefix: String, params: List<Parameter>): List<String> {
    val result = mutableListOf<String>()
    for (param in params) {
        if (param.name.startsWith(prefix)){
            result.add("--set \"%${param.name}%\"")
        }
    }
    return result.toList()
}
