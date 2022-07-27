description = "Represents a convenience module which merely bundles dependencies."

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(prefixedProject("verbs"))
                api(prefixedProject("api-fluent-en_GB"))
                api(prefixedProject("translations-en_GB"))
            }
        }
        val jvmMain by getting{
            dependencies {
                api(prefixedProject("verbs"))
                api(prefixedProject("api-fluent-en_GB"))
                api(prefixedProject("translations-en_GB"))
            }
        }
    }
}

val jacocoAdditional by extra(
    listOf(
        prefixedProject("verbs"),
        prefixedProject("translations-en_GB"),
        prefixedProject("logic"),
        prefixedProject("core")
    )
)