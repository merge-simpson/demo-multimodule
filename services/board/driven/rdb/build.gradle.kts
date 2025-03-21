java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    api(project(":board:api"))
    api(project(":board:application"))
    api(project(":nettee:jpa-core"))

    compileOnly("org.springframework.boot:spring-boot-starter-data-jpa")

    // if flyway configuration required
    compileOnly("org.flywaydb:flyway-database-postgresql")

    // mapstruct
    compileOnly("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

    // enum util
    api("com.github.merge-simpson:enum-util:0.1.0")
}