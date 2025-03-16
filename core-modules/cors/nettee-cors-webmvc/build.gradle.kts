java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {

}

tasks.test {
    useJUnitPlatform()
}