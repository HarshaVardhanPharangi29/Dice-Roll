allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

// ✅ Set root project build directory
buildDir = file("../../build/root")

// ✅ Set subproject build directories
subprojects {
    buildDir = file("../../build/${project.name}")
    evaluationDependsOn(":app")
}

// ✅ Clean task
tasks.register<Delete>("clean") {
    delete(rootProject.buildDir.parentFile) // Deletes ../../build entirely
}
