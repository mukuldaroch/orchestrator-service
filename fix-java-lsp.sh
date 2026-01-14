#!/usr/bin/env bash

set -e

echo "Nuking jdtls caches..."
rm -rf ~/.cache/jdtls
rm -rf ~/.local/share/jdtls
rm -rf ~/.local/state/jdtls
rm -rf ~/.local/share/nvim/lsp-workspaces
# rm -rf ~/.cache/nvim

echo "Killing Java language servers..."
pkill jdtls 
pkill gradle
pkill java 

PROJECT_ROOT="$(pwd)"

if [ -f "$PROJECT_ROOT/gradlew" ]; then
  echo " Rebuilding Gradle project..."
  ./gradlew clean build -x test
else
  echo "No Gradle or Maven project found here."
fi

