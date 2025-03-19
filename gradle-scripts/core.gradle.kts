val coreDir = "${rootProject.projectDir}/core-modules"

include(
    ":nettee:jpa-core",
    ":nettee:cors-webmvc",
    ":nettee:cors-api",
    ":nettee:exception-handler-webmvc",
    ":nettee:locale-webmvc",
)

project(":nettee:jpa-core").projectDir = file("$coreDir/nettee-jpa-core")
project(":nettee:cors-webmvc").projectDir = file("$coreDir/cors/nettee-cors-webmvc")
project(":nettee:cors-api").projectDir = file("$coreDir/cors/nettee-cors-api")
project(":nettee:exception-handler-webmvc").projectDir =
    file("$coreDir/exception-handler/nettee-global-exception-handler-webmvc")
project(":nettee:locale-webmvc").projectDir = file("$coreDir/i18n/locale-webmvc")