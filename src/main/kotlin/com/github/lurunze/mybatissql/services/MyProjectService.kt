package com.github.lurunze.mybatissql.services

import com.intellij.openapi.project.Project
import com.github.lurunze.mybatissql.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
