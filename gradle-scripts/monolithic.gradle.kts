val monolithicDir = "${rootProject.projectDir}/monolithic"

include(
    ":monolithic-main-runner",
)

project(":monolithic-main-runner").projectDir = file("$monolithicDir/main-runner")