package com.sharekey

import jetbrains.buildServer.configs.kotlin.v2019_2.Parameter

fun GatherHelmSetParameters(params: List<Parameter>, prefix: String = HelmSetParamPrefix): List<String> {
    val result = mutableListOf<String>()
    for (param in params) {
        if (param.name.startsWith(prefix) && param.spec != ParameterPassword){
            result.add("--set \"%${param.name}%\"")
        }
    }
    return result.toList()
}
