#!/bin/bash

# Maven commands
MAVEN="mvn"
COMPILE_CMD="${MAVEN} compile"
PACKAGE_CMD="${MAVEN} package"
TEST_CMD="${MAVEN} test"
EXECUTE_CMD="${MAVEN} exec:java"

# Check if Maven is installed
if command -v mvn &> /dev/null; then
    echo "Maven is installed."
else
    echo "Maven is not installed. Please install Maven before running this script."
    exit 1
fi

# Compile
echo "Compiling..."
${COMPILE_CMD}
if [ $? -ne 0 ]; then
    echo "Compilation failed."
    exit 1
fi

# Package
echo "Packaging..."
${PACKAGE_CMD}
if [ $? -ne 0 ]; then
    echo "Packaging failed."
    exit 1
fi

# Test
echo "Running tests..."
${TEST_CMD}
if [ $? -ne 0 ]; then
    echo "Tests failed."
    exit 1
fi

# Run
echo "Running the application..."
${EXECUTE_CMD}
if [ $? -ne 0 ]; then
    echo "Execution failed."
    exit 1
fi

echo "Poker game script completed successfully."
