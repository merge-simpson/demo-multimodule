java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    api(project(":board:api"))
    api(project(":board:application"))
    api(project(":nettee:locale-webmvc"))

    // validation annotation
    compileOnly("jakarta.validation:jakarta.validation-api")
    compileOnly("jakarta.annotation:jakarta.annotation-api")

    // mapstruct
    compileOnly("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
}