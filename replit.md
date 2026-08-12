# Convx

Convx is a Kotlin/Jetpack Compose Android music player built with Gradle. The repository also contains a separate `listen-together-server` Cloudflare Worker project.

## Replit notes

- Android builds require an Android SDK and are not browser-previewable.
- User-facing customization settings are controlled by `config/app.properties`; set `allSettings=true` to expose the temporarily hidden presets, player icons, and DIY settings.
- Release signing uses CI-provided keystore secrets. The release workflow detects JKS vs PKCS12 before Gradle runs.