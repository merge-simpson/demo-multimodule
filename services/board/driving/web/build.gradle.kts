java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    api(project(":board:api"))
    api(project(":board:application"))

    // mapstruct
    compileOnly("org.mapstruct:mapstruct:1.6.3")
}