---
name: Release keystore format
description: CI release signing needs an explicit keystore type and pre-build validation.
---

Android release builds must not rely on the JVM default keystore type. The CI signing secret may be JKS while newer Java runtimes default to PKCS12, which can surface as a misleading “Tag number over 30 is not supported” error.

**Why:** The repository’s release keystore format is supplied through CI secrets and is not available in the workspace, so Gradle cannot safely infer it from source alone.

**How to apply:** Detect JKS or PKCS12 with `keytool` after decoding the secret, export the detected type to the build, and fail before Gradle if the secret/password cannot open either format.