java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("jakarta.persistence:jakarta.persistence-api")
    compileOnly("org.springframework.data:spring-data-commons")
    compileOnly("org.springframework.data:spring-data-jpa")
    compileOnly("org.springframework.boot:spring-boot-autoconfigure")
}

tasks.test {
    useJUnitPlatform()
}