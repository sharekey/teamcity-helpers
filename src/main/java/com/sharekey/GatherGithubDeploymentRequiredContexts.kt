package com.sharekey

import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType

fun GatherGithubDeploymentRequiredContexts(projectName: String, requiredBuildTypes: ArrayList<BuildType>): List<String> {
    val requiredContexts = mutableListOf<String>()
    for (requiredBuildType in requiredBuildTypes) {
        requiredContexts.add("${requiredBuildType.name} (${projectName})")
    }
    return requiredContexts.toList()
}
