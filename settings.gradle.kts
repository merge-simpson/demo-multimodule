rootProject.name = "demo-multimodule"

val gradleScriptsDir = "gradle-scripts"

apply(from = "$gradleScriptsDir/common.gradle.kts")
apply(from = "$gradleScriptsDir/core.gradle.kts")
