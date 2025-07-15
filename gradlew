#!/usr/bin/env sh
# Gradle wrapper script for Unix systems
# This script will download and invoke the Gradle wrapper

set -e

DIR="$(cd "$(dirname "$0")" && pwd)"
GRADLE_WRAPPER_JAR="$DIR/gradle/wrapper/gradle-wrapper.jar"
GRADLE_WRAPPER_PROPERTIES="$DIR/gradle/wrapper/gradle-wrapper.properties"

if [ ! -f "$GRADLE_WRAPPER_JAR" ]; then
  echo "Downloading Gradle wrapper jar..."
  mkdir -p "$DIR/gradle/wrapper"
  curl -o "$GRADLE_WRAPPER_JAR" https://services.gradle.org/distributions/gradle-wrapper.jar
fi

exec java -jar "$GRADLE_WRAPPER_JAR" "$@"
