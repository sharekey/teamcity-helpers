package com.sharekey

import jetbrains.buildServer.configs.kotlin.v2019_2.Parameter

const val helmSetParamPrefix = "helm.set."
fun GatherHelmSet(params: List<Parameter>): List<String> {
    val result = mutableListOf<String>()
    for (param in params) {
        if (param.name.startsWith(helmSetParamPrefix)){
            result.add("--set \"%${param.name}%\"")
        }
    }
    return result.toList()
}
