java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    api("com.github.merge-simpson:letsdev-error-code-api:0.2.0")
}

tasks.test {
    useJUnitPlatform()
}