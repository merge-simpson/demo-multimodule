java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    api(project(":board:api"))
    api(project(":board:application"))

    // if flyway configuration required
    compileOnly("org.flywaydb:flyway-database-postgresql")
}