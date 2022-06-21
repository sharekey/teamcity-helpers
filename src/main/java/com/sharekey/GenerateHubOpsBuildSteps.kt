package com.sharekey

import jetbrains.buildServer.configs.kotlin.Parameter
import jetbrains.buildServer.configs.kotlin.BuildSteps
import jetbrains.buildServer.configs.kotlin.buildSteps.script

fun GenerateHubOpsBuildSteps(params: List<Parameter>, prefix: String = HubOpsParamPrefix): BuildSteps.() -> BuildSteps {
    return fun BuildSteps.() = apply {
        for (param in params) {
            if (param.name.startsWith(prefix) && param.spec != ParameterPassword) {
                val paramName = param.name.removePrefix(prefix)
                script {
                    id = "set_${paramName}"
                    name = "set ${paramName}"

                    conditions {
                        doesNotEqual(param.name, "")
                    }

                    scriptContent = """
                        #!/usr/bin/env bash

                        echo "##teamcity[setParameter name='${paramName}' value='%${param.name}%']"
                    """.trimIndent()
                }
            }
        }
    }
}
