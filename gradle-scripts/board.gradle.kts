// bundler module
include(":board")

// API modules
include(
    ":board:api",
    ":board:domain",
    ":board:readmodel",
    ":board:exception",
)

project(":board").projectDir = file("${rootProject.projectDir}/services/board")
project(":board:api").projectDir = file("${rootProject.projectDir}/services/board/api")
project(":board:domain").projectDir = file("${rootProject.projectDir}/services/board/api/domain")
project(":board:readmodel").projectDir = file("${rootProject.projectDir}/services/board/api/readmodel")
project(":board:exception").projectDir = file("${rootProject.projectDir}/services/board/api/exception")