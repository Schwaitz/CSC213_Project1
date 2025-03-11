#!/bin/bash

# Define variables
SRC_DIR="src/main/java"
OUT_DIR="out"
JAR_FILE="uniquehands.jar"
MAIN_CLASS="main.java.edu.canisius.csc213.project1.UniqueHands"


# Create output directory if it doesn't exist
mkdir -p $OUT_DIR


# Clean previous build
echo "🧹 Cleaning previous build..."
# TODO You figure this out
rm -r ./$OUT_DIR/*

# Compile Java files
echo "🚀 Compiling Java files..."
javac -d $OUT_DIR -cp "lib/*" $(find $SRC_DIR -name "*.java")

# Package into a JAR
echo "📦 Creating JAR file..."
jar cfe $OUT_DIR/$JAR_FILE $MAIN_CLASS -C $OUT_DIR .

# Done!
echo "✅ Build complete! Run it with: java -jar $JAR_FILE"