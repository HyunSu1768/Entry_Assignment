dependencies {
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":entry-common"))
    implementation(project(":entry-core"))
    implementation(project(":entry-infrastructure"))
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}