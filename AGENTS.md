# Finviz API Agent Guide

This document provides guidance for AI agents working with the `finviz-api` codebase.

## Project Overview

`finviz-api` is a Java library designed to scrape stock market data from the [Finviz](https://finviz.com) website. It provides a simple API to filter stocks using the Finviz screener and retrieve a list of matching ticker symbols.

The core functionality involves:
- Building a valid Finviz screener URL based on user-provided filter criteria.
- Fetching the HTML content of the screener page.
- Parsing the HTML to extract stock tickers.
- Handling pagination for result sets that span multiple pages.

## Build and Testing

The project is built and managed using **Apache Maven**.

- **To build the project and run all tests**, execute the following command from the root directory:
  ```bash
  mvn clean install
  ```
- **To run only the tests**, use:
  ```bash
  mvn test
  ```

Dependencies are defined in the `pom.xml` file. The project requires **Java 11** or higher.

## Codebase Guide

The codebase is organized into several key components:

- **`pom.xml`**: The Maven project object model file. It defines project dependencies, build plugins, and other configuration.

- **`src/main/java/ua/com/gfalcon/finviz/screener/FinvizScreener.java`**: This is the primary class for interacting with the Finviz screener. It takes a list of filter parameters, constructs the appropriate URL, executes the web request, and parses the resulting tickers.

- **`src/main/java/ua/com/gfalcon/finviz/screener/filter/`**: This package contains the various filter parameters that can be applied to the screener (e.g., `MarketCap`, `Price`, `Signal`).

- **`src/main/java/ua/com/gfalcon/finviz/overview/Stock.java`**: Represents a single stock's data. *(Note: While this class exists, the primary functionality of the screener is to return ticker symbols as Strings).*

- **`src/test/`**: This directory contains all unit tests for the project. When adding new features or fixing bugs, it is crucial to add or update tests in this directory to ensure correctness and prevent regressions.
