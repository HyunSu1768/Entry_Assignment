dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}